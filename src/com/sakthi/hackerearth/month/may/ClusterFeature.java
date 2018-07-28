package com.sakthi.hackerearth.month.may;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cluster feature
 * https://www.hackerearth.com/practice/data-structures/advanced-data-structures/
 * fenwick-binary-indexed-trees/practice-problems/algorithm/cluster-features-b6d64df9/
 * 
 * @author sakthivel
 */
public class ClusterFeature {

	public void init() {
		Scanner scanner = null;
		File file = new File("src/res.txt");
		FileWriter fileWriter = null;
		BufferedWriter bfferedWriter = null;
		try {
			scanner = new Scanner(System.in);
			int p = scanner.nextInt();
			int q = scanner.nextInt();

			List<Point> points = new ArrayList<Point>();

			for (int index = 0; index < p; index++) {
				Point point = new Point();
				point.setX(scanner.nextInt());
				point.setY(scanner.nextInt());
				points.add(point);
			}

			List<Cluster> clusters = new ArrayList<Cluster>();
			for (int index = 0; index < q; index++) {
				Cluster cluster = new Cluster();
				cluster.setX1(scanner.nextInt());
				cluster.setX2(scanner.nextInt());
				cluster.setY1(scanner.nextInt());
				cluster.setY2(scanner.nextInt());
				clusters.add(cluster);
			}

			// System.out.println("\n# of Points is " + points.size());
			// System.out.println("# of clusters is " + clusters.size());

			fileWriter = new FileWriter(file);
			bfferedWriter = new BufferedWriter(fileWriter);
			Long res = 1L;
			int x0, y0, n;
			double radius, diameter;
			int index = 0;
			for (Cluster c : clusters) {
				List<Point> clusteredPts = getX0Y0(points, c);
				if (clusteredPts != null && !clusteredPts.isEmpty()) {
					Point centroid = clusteredPts.remove(clusteredPts.size() - 1);
					n = clusteredPts.size();
					x0 = centroid.getX();
					y0 = centroid.getY();
					radius = 0;
					diameter = 0;
					if (n > 0) {
						radius = calculateRadius(clusteredPts, x0, y0);
					}
					if (n > 1) {
						diameter = calculateDiameter(clusteredPts);
					}

					System.out.println(" >>>>" + index++);
					bfferedWriter.write(((n * x0) + (n * y0) + (n * n * (Math.sqrt(radius / n)) * Math.sqrt(radius / n))
							+ (n * (n - 1) * Math.sqrt(diameter / (n * (n - 1))) * Math.sqrt(diameter / (n * (n - 1)))))
							+ "\n");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (scanner != null) {
					scanner.close();
				}
				if (bfferedWriter != null) {
					bfferedWriter.close();
				}
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (Exception e) {
				System.err.println("in final " + e);
			}
		}
	}

	protected int calculateDiameter(final List<Point> points) {
		// double diamater = 0;
		int deltaDiameter = 0;
		int deltaX;
		int deltaY;
		for (int index = 0; index < points.size(); index++) {
			for (Point p : points) {
				deltaX = points.get(index).getX() - p.getX();
				deltaY = points.get(index).getY() - p.getY();
				deltaDiameter = deltaDiameter + (deltaX * deltaX) + (deltaY * deltaY);
			}
		}
		// if (deltaDiameter > 0) {
		// diamater = Math.sqrt(deltaDiameter / (points.size() * (points.size()
		// - 1)));
		// System.out.println("deltaDiameter=" + deltaDiameter + ", n=" +
		// points.size() + ", diamater=" + diamater);
		// }
		return deltaDiameter;
	}

	protected int calculateRadius(final List<Point> points, final int x0, final int y0) {
		double radius = 0;
		int deltaRadius = 0;
		int deltaX;
		int deltaY;
		for (Point point : points) {
			deltaX = point.getX() - x0;
			deltaY = point.getY() - y0;
			deltaRadius = deltaRadius + (deltaX * deltaX) + (deltaY * deltaY);
		}
		// if (deltaRadius > 0) {
		// radius = Math.sqrt(deltaRadius / points.size());
		// System.out.println("AvgDistance=" + deltaRadius + ", n=" +
		// points.size() + ", avgDistance=" + radius);
		// }
		return deltaRadius;
	}

	protected List<Point> getX0Y0(final List<Point> allPoints, final Cluster cluster) {
		int x0 = 0;
		int y0 = 0;
		List<Point> points = new ArrayList<Point>();
		for (Point p : allPoints) {
			if ((cluster.getX1() <= p.getX() && p.getX() <= cluster.getX2())
					&& (cluster.getY1() <= p.getY() && p.getY() <= cluster.getY2())) {
				x0 = x0 + p.getX();
				y0 = y0 + p.getY();
				points.add(p);
			}
		}
		if (!points.isEmpty()) {
			Point point = new Point();
			point.setX(x0 / points.size());
			point.setY(y0 / points.size());
			points.add(point);
		}
		// System.out.println("Size=" + (points.size() - 1));
		return points;
	}
}

class Point {
	int x;
	int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

class Cluster {

	int x1;
	int y1;
	int x2;
	int y2;

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	@Override
	public String toString() {
		return "Cluster [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}

}