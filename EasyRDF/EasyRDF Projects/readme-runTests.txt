1. First need to make sure apache fuseki is running, if not then execute
D:\Programming\apache-jena-fuseki-3.4.0 openllet\fuseki-server.bat

2A. In graphviz2.php I changed the lines
$ul = 1;

$ol = 0;

manually to each of the four possibilities, each time running the respective
php command from the command prompt (cmd.exe window)

php graphviz2.php > ..\output\graphviz2-output--ul0-ol0.png
php graphviz2.php > ..\output\graphviz2-output--ul0-ol1.png
php graphviz2.php > ..\output\graphviz2-output--ul1-ol0.png
php graphviz2.php > ..\output\graphviz2-output--ul1-ol1.png

I found that the option that works best is $ul=1; $ol=0; all the other
options either make no difference to the output, or produce no graph in the
resulting image.

2B. Then I set $ul="1"; $ol="0";

and manually in the command prompt (cmd.exe) window ran
php graphviz2.php > ..\output\graphviz2-output-ul1-ol0-bothInQuotes.png

I found that quotes make no difference to the output result.

2C. Then I set $ul=true; $ol=false;

and manually in the command prompt (cmd.exe) window ran
php graphviz2.php > ..\output\graphviz2-output-ultrue-olfalse.png

I found that using true and false makes no difference to the output result.

2D. Then I set $ul="true"; $ol="false";

and manually in the command prompt (cmd.exe) window ran
php graphviz2.php > ..\output\graphviz2-output-ultrue-olfalse-bothInQuotes.png

I found that using "true" and "false" (ie in quotes) results
in image output with no graph.

3. For the automatic test running, rename
runTests.bat.txt
to
runTests.bat
and then run in a command prompt window, executing runcmd.bat will easily bring
up a command prompt window.

------------------------------------------------------------------

