bullshit-paper
==============

# Run

You have to have [maven](http://maven.apache.org) and git. Simply clone:

```
git clone https://github.com/neojski/bullshit-paper
```

Then you can use just maven stuff to install dependencies:

```
mvn package
```

It also runs tests. In case you're changing something tests can be fired with
`mvn test`. (use `-Dtest=bullshit_paper.NameOfTest` to run single test)

To make JavaFX work you need to have the latest version of Java and add jfxrt.jar to the local maven repository:
```
mvn install:install-file -Dfile="C:\Program Files\Java\jre7\lib\jfxrt.jar" -DgroupId=com.oracle -DartifactId=javafx -Dversion=2.2.45 -Dpackaging=jar
```

# Dict
To use the `Dict` class you have to download the dictionary from
[sjp](http://sjp.pl/slownik/odmiany) and then convert it to utf8:

```
iconv -f WINDOWS-1250 -t utf-8 odm.txt > odm
```

It is necessary to have this file in unix endlines format. You can get help on
this
[here](http://www.cyberciti.biz/faq/howto-unix-linux-convert-dos-newlines-cr-lf-unix-text-format)

Once you're done just throw it into the resources directory for dictionary (`/bullshit-paper/src/main/resources/dict`)


# Run project with GUI

You need JavaFX to do it. Download from: http://www.oracle.com/technetwork/java/javafx/downloads/index-jsp-136193.html

Then install like above: 
```
mvn install:install-file -Dfile="[path_to_jfxrt_jar]" -DgroupId=com.oracle -DartifactId=javafx -Dversion=2.2.45 -Dpackaging=jar
```
where path_to_jfxrt_jar is for example C:\Program Files\Java\jre7\lib\jfxrt.jar

Last thing to do - run the project using 
`make run`
in the top directory of the project.