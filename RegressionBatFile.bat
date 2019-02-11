set projectLocation=\RegressionSuite
cd %projectLocation%
set classpath=%projectLocation%\RegSuite.jar 
java -jar RegSuite.jar >>logs.txt
pause
