# Poker Hands Kata  

## Criteria:  
Compare poker hands and output which, if either, is the winning hand, along with the hand rank and any kickers.  

### Sample input:
Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH  
Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S  
Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH  
Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH  

### Sample output:
White wins. - with high card: Ace  
Black wins. - with full house: 4 over 2  
Black wins. - with high card: 9  
Tie.  

## Assumptions:
Assumed it was ok to change the output message to reflect the winning hand in more detail.  
e.g. White wins. - with two pair: Tens/Twos & Ace kicker.

## Process followed:
I began by sketching out an overview of how I thought the programme should flow.  
I wrote an initial failing test to check if either hand contained a flush as I thought this would be the easiest rank to detect.  
I created a boolean method to check for flush and the test passed.  
I then wrote failing tests and methods for all hand rankings.  
Once all tests were passing, I wrote a failing test to check for hand value e.g. Ace high flush = 114.  
Wrote method to calculate hand value and pass the test above.  
Then I wrote failing tests to test input hands resulting in the correct hand winning.  
Refactored methods to compare hands and pass the failing tests.  
Wrote failing tests to test for the correct output message.  
Refactored code to pass the failing tests.  
Final refactor of code, added finals where appropriate, and a general clean up.  
