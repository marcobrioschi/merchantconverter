package biz.brioschi.merchantconverter;

import biz.brioschi.merchantconverter.intergalacticmoney.EarthMapper;
import biz.brioschi.merchantconverter.intergalacticmoney.IntergalacticMapper;
import biz.brioschi.merchantconverter.intergalacticmoney.MoneyMapper;
import biz.brioschi.merchantconverter.intergalacticmoney.TimeMasterMapper;

import java.util.*;

public class Main {

    private static final String TIME_MASTER_FLAG = "--timemaster";

    public static void main(String[] args) {

        OptionalInt timeMasterFlag = findTimeMasterFlag(args);
        Converter converter = buildConverter(timeMasterFlag);

        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            System.out.printf("Give me the string please or type 'exit':\n");
            line = scanner.nextLine();
            if (!"exit".equals(line)) {
                try {
                    Map<String, String> result = converter.processExpression(line);
                    for (String key : result.keySet()) {
                        System.out.printf("%20s = %s\n", key, result.get(key));
                    }
                } catch (Exception e) {
                    System.out.printf("ERROR: %s\n", e.getMessage());
                }
            };
            System.out.printf("-----------------------\n\n");
        } while (!"exit".equals(line));
        System.out.println("Have a nice day :-)");

    }

    private static OptionalInt findTimeMasterFlag(String[] args) {
        return Arrays
                .stream(args)
                .filter(arg -> TIME_MASTER_FLAG.equals(arg))
                .mapToInt(arg -> 1)
                .findAny();
    }

    private static Converter buildConverter(OptionalInt timeMasterFlag) {
        List<MoneyMapper> mappers = new ArrayList<>();
        mappers.add(new EarthMapper());
        if (timeMasterFlag.isPresent() && timeMasterFlag.getAsInt() == 1) {
            System.out.printf("Enabled the TimeMaster Dialect\n");
            mappers.add(new TimeMasterMapper());
        } else {
            mappers.add(new IntergalacticMapper());
        }
        return new Converter(mappers);
    }

}
