# Java ClassLoader simple example

This example demonstrates how to execute a the same method of the same class but from different versions (jars)

Libv1 and Libv2 simulates different versions of the same library. Both implements the same class (cat.altimiras.classloader.TheClass) with the same method (get(String name)) that returns a dummy text.  
Main class load those jars in different classloaders and executes that method per each version

Output:
Version: "version2" Output: "Hello world Buzz light year from TheClass implemented in v2"
Version: "version1" Output: "Hello world Buzz light year from TheClass implemented in v1"



