package biz.brioschi.merchantconverter;

import biz.brioschi.merchantconverter.intergalacticmoney.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Converter {

    private List<MoneyMapper> mappers;
    private PrintStream writer;

    public Converter(PrintStream writer) {
        this.mappers = new ArrayList<>();
        this.mappers.add(new EarthMapper());
        this.mappers.add(new IntergalacticMapper());
        this.writer = writer;
    }

    private void processData(String[] values) {
        for (String value : values) {
            processData(value);
        }
    }

    private void processData(String value) {
        MoneyMapper decodeMapper = findCompatibleMapper(value);
        if (decodeMapper != null) {
            try {
                Money money = decodeMapper.buildFromString(value);
                writer.printf("The '%s' is valid money value:\n", value);
                for (MoneyMapper printMapper : mappers) {
                    writer.printf("\t\t%10s\t\t%s\n", printMapper.getMapperDescription(), printMapper.toString(money));
                }
            } catch (IntergalacticMoneyException e) {
                writer.printf("The string '%s' isn't a valid money value [%s]\n", value, e.getMessage());
            }
        } else {
            writer.printf("The string '%s' isn't a valid money value\n", value);
        }
    }

    private MoneyMapper findCompatibleMapper(String value) {
        for (MoneyMapper mapper : mappers) {
            if (mapper.isCompatibleString(value)) {
                return mapper;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Converter converter = new Converter(System.out);

        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            String line;
            do {
                System.out.printf("Give me the string please or type 'exit':\n");
                line = scanner.nextLine();
                if (!"exit".equals(line)) {
                    converter.processData(line);
                };
                System.out.printf("-----------------------\n\n");
            } while (!"exit".equals(line));
            System.out.println("Have a nice day :-)");
        } else {
            converter.processData(args);
        }

    }

}
