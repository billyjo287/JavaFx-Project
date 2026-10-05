# Builds votingapplication.jar (replaces Eclipse's File > Export > Runnable JAR file)
$ErrorActionPreference = 'Stop'
Set-Location $PSScriptRoot

$fx = "javafx-sdk-17.0.2\lib"
$classes = "build\classes"

if (Test-Path build) { Remove-Item -Recurse -Force build }
New-Item -ItemType Directory -Force $classes | Out-Null

# compile the source
javac --module-path $fx --add-modules javafx.controls,javafx.fxml -d $classes src\application\Main.java
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

# copy the img source folder contents to the root of the jar (so "/Java_Duke.png" resolves)
Copy-Item img\* $classes

# create the runnable jar with application.Main as the entry point
jar --create --file votingapplication.jar --main-class application.Main -C $classes .
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }

Write-Host "Created votingapplication.jar"
