@echo off
echo [CMMI] Production Facade stage Interface API documentation.
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

echo [Step 1]  Into Facade stage path.
cd ..
cd modules\common\service

call %MVN% clean site:site -Prefresh-synopsis  

goto end 

:end
pause