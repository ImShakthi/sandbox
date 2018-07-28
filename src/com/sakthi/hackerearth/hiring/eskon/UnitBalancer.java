package com.sakthi.hackerearth.hiring.eskon;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UnitBalancer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UnitBalancer().init();
	}

	public void init() {
		Scanner scanner = null;
		try {
			Map<String, Unit> unitMap = new HashMap<String, Unit>();

			scanner = new Scanner(System.in);

			// To scan all units
			String units = scanner.nextLine();
			String[] unitsArr = getUnitArr(units);

			if (unitsArr.length == 1) {
				System.out.println(unitsArr.length + units);
			} else {
				String unitExp = "";
				// To get all unit relationship and create a map
				for (int index = 0; index < unitsArr.length - 1; index++) {

					// relationship a = b c
					String unitRelation = scanner.nextLine();

					// convert relationship equation into string array
					// a = b c -> day = 24 hour
					// 0th index as a
					// 1th index as '='
					// 2nd index as b
					// 3rd index as c
					String[] unitRelArr = unitRelation.split("\\s");

					// child unit
					Unit unit = new Unit();
					unit.setValue(Long.parseLong(unitRelArr[2]));
					unit.setName(unitRelArr[3]);

					unitMap.put(unitRelArr[0], unit);
				}

				BigInteger prevUnit = BigInteger.ONE;

				String unitName = getHeadUnit(unitMap);
				Unit unit = unitMap.get(unitName);
				while (unit != null) {
					unit = unitMap.get(unitName);
					if (unit != null) {
						unitExp += prevUnit + unitName + " = ";
						prevUnit = prevUnit.multiply(new BigInteger(unit.getValue() + ""));
						// prevUnit = prevUnit * unit.getValue();
						unitName = unit.getName();
					} else {
						unitExp += prevUnit + unitName + " = ";
					}
				}
				// final output
				System.out.println(unitExp.substring(0, unitExp.length() - 3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private String getHeadUnit(final Map<String, Unit> unitMap) {
		String headUnit = "";
		Set<String> keys = unitMap.keySet();
		for (String key : keys) {
			boolean unitPresent = false;

			Set<String> inner_keys = unitMap.keySet();
			for (String inner_key : inner_keys) {
				Unit unit = unitMap.get(inner_key);
				if (key.equalsIgnoreCase(unit.getName())) {
					unitPresent = true;
					break;
				}
			}
			if (!unitPresent) {
				headUnit = key;
				break;
			}
		}
		System.out.println(unitMap);
		System.out.println("HEAD=" + headUnit);
		return headUnit;
	}

	private String[] getUnitArr(final String units) {
		return units.split(",");
	}
}

/**
 * Class to hold the unit properties
 * 
 * @author sakthivel
 *
 */
class Unit {
	private long value;
	private String name;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Unit [value=" + value + ", name=" + name + "]";
	}
}