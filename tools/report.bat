@echo off
echo [CMMI] create report .
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

cd ..
call %MVN% clean site:site

goto end 

:end
pause