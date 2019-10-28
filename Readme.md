# Calculator Demo

### Compile single module
javac -d out/lib.module lib.module/module-info.java lib.module/com/esempla/lib/Math.java

### Compile multiple module
javac -d out --module-source-path . calculator.module/module-info.java calculator.module/com/esempla/calculator/Main.java

or 

javac -d out --module-source-path . -m calculator.module

or (in Linux)

javac -d out --module-source-path . $(find . -name "*.java")

### Run application containing single module
java --module-path out --module calculator.module/com.esempla.calculator.Main

java --module-path out -m calculator.module/com.esempla.calculator.Main

### Create jar module (packaging module)
jar --create --file lib/calculator.jar --main-class com.esempla.calculator.Main -C out/calculator.module .

jar --create --file lib/math-lib.jar -C out/lib.module .

### Run application in module path
java --module-path lib --module calculator.module

or

java --module-path lib/math-lib.jar;lib/calculator.jar -m calculator.module

### Run application in class path
java -cp lib/math-lib.jar;lib/calculator.jar com.esempla.calculator.Main

### Linking modules (Create custom java image)
jlink --module-path lib;$JAVA_HOME/jmods --add-modules lib.module --add-modules calculator.module --launcher launcher=calculator.module --output image

jlink --module-path lib;$JAVA_HOME/jmods --add-modules lib.module --add-modules calculator.module --launcher launcher=calculator.module --output imagez --compress 2 --strip-debug

### Run 
image\bin\java -m calculator.module

or 

image\bin\launcher.bat
sh image\bin\launcher