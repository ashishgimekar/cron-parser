# cron-parser

1. From project home run following command to build jar file:
```sh
mvn clean package
```


2. Locate the cron-parser.jar file in target folder and execute
```sh
java -jar <path_of_target_folder>/cron-parser.jar <input_cron_expression>
```

For example: 
```sh
java -jar Documents/cron-parser/target/cron-parser.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

3. Input should be given in a single argument as a String. Following should be the input format:

```sh
minute hour day_of_month month day_of_week command
```
