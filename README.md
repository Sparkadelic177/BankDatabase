# BankDatabase

## Summary
  Design and implement a simple database system for a bank and provided an API that works with the database to create, view, update and delete information. 

## The “backend”
  From a broad perspective, the database consist of a list of accounts. Clients and bank workers and/or administrators can then perform transactions and other actions on those accounts.

## Accounts
  Each client can have a checking account, a credit card account, or a combination of both - each with a separate and unique account number. However, personal information about the account owner should only be stored once. In other words, there should not be two separate account objects storing the same personal information. Choose an appropriate data structure to represent this idea.
	Additional clarification: for example, John Doe owns two accounts in the back, one checking account with account number 1001 and one credit card account 2002. If we were to change the personal information for 1001, then the change should be reflected on account 2002 as well. There should not be a case where 1001’s owner becomes Jonny Doe and 2002 is still owned by John Doe.

## Transactions
  Clients should be able to perform transactions on their accounts.For example, you can make deposits to the checking account, make purchases with the credit card account and use the checking account to pay back what the credit card account owes.

## Other Actions
  Bank workers and/or administrators should be able to open, close, and modify accounts, as well as checking all account information and running reports. 

## The “frontend”
  Ultimately, we then want a main function that links a file reader class that reads the inputs and translates them to functions calls to the API. Additionally, the program should generate a log file and an output file.

## File reader class
  To read the file that as used as database

## Inputs
  All the transactions/actions should be handled from an input file (not the console) where each line corresponds to each action.
  For example, a line in the input file that says
  NCA JOHN DOE 123000456 500.00
  This can mean John Doe just opened a new checking account with a $500 initial deposit, his social security number is 123000456.
  PCC 20812 41998 125.33
  This can mean pay credit card from account 20812 to 41998 with the amount of $125.33

## Log and output files
  The log file should contain the list of results for each and every action performed. For example, after a deposit action, the log file should have a line that that states “deposit successful for x account of y amount”.
	The output file should provide a snapshot of the state of the database before the program terminates.
