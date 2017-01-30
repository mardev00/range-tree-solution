# WSI Coding Challenge

The project uses maven and it produces a jar file that can be built using the following command:
  mvn clean install
This command will also run the test cases.

There are two Java classes included in this project. 

Class RangeTree uses a BST data structure to store zip code ranges. These ranges maybe combined inside the BST if there is an overlap.

Class RangeTreeTest is provided to test the algorithm and can be extended to add more test cases.

SAMPLE TEST CASES

If the input = [08500,08540] [08520,08560] [08621,08635]
Then the output should be = [08500, 08560] [08621,08635] 

If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699] 

If the input = [94133,94133] [94200,94299] [94226,94399]
Then the output should be = [94133,94133] [94200,94399]
