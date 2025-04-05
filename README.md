# RE08_Group3_A2

The program uses relative path, please change the working path to:
*\RE08_Group3_A2\app

All json and txt files are stored in the resource folder.
resource folder path: *\RE08_Group3_A2\app\src\main\resources

run the program with the 'gradle run' command

Run the 'gradle test' command to test

All reports are generated in the app/src/main/resources directory:
reports for seller:
A list of the current available items that include the item details: app/src/main/resources/sellerCurrentItemsReport.txt
A summary that includes items codes, item names and the total number of quantity sold for each item: app/src/main/resources/sellerSoldReport.txt

reports for owner:
A list of usernames in the vending machine with the associated role: app/src/main/resources/ownerUsersReport.txt
A summary of cancelled transaction. This summary only includes date and time of the cancelled, the user and the reasons: app/src/main/resources/ownerCancelTransactionReport.txt

reports for cashier:
A list of the current available change: app/src/main/resources/money_in_VendingMachine.txt
A summary of transactions that includes transaction date and time, item sold, amount of money paid, returned change and payment method:app/src/main/resources/transactionReport.txt

Note: All paths use relative paths. You may need to change/to \\\\
