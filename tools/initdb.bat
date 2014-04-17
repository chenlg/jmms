@echo off
echo [CMMI] bulid tables .
echo [Author] lingang.chen@gmail.com

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m 

cd ..
cd modules\core\persistant\repository
call %MVN% antrun:run -Prefresh-db

goto end 

:end
pause