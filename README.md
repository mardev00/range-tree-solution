# WSI Coding Challenge

The project uses maven and it produces a jar file that can be built using the following command:
  mvn clean install
This command will also run the test cases.

There are two Java classes included in this project. 

Class RangeTree uses a BST data structure to store zip code ranges. These ranges maybe combined inside the BST if there is an overlap.

Class RangeTreeTest is provided to test the algorithm and can be extended to add more test cases.

SAMPLE TEST CASES

If the input = [98500,08540] [98520,98560] [98621,98635]
Then the output should be = [98500, 98560] [98621,98635] 

If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699] 

If the input = [94133,94133] [94200,94299] [94226,94399]
Then the output should be = [94133,94133] [94200,94399]
