@echo off
echo [CMMI] package .
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m 

cd .. 
call %MVN% package -DskipTests=true

goto end 

:end
pause
 