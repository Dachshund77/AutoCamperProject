-- Test for sp_addZip
GO
EXEC sp_AddZip '6400', 'Sønderborg WRONG'
EXEC sp_AddZip '6400', 'Sønderborg' -- Should Update
EXEC sp_AddZip '6430', 'Nordborg'
EXEC sp_AddZip '6440', 'Augustenborg'
EXEC sp_AddZip '10100', 'Flensburg'

-- Test for sp_DeleteZip
GO
EXEC sp_AddZip '9999', 'Should be deleted'
EXEC sp_DeleteZip '9999'

-- Test for sp_AddCustomer
GO
EXEC sp_AddCustomer NULL, 'Sven B', '22370792', 'Sven.buechner.privat@googlemail.com', '6400', 'Helgolandsgade'
EXEC sp_AddCustomer 1, 'Should be deleted', '22370792', 'Sven.buechner.privat@googlemail.com', '6400', 'Helgolandsgade'
EXEC sp_AddCustomer NULL, 'Sven B', '22370792', 'Sven.buechner.privat@googlemail.com', '6400', 'Helgolandsgade'
EXEC sp_AddCustomer NULL, 'Hans', '72470122', NULL, '6430', 'Søgade'
EXEC sp_AddCustomer NULL, 'Peter S', '12270152', NULL, '6430', 'Frankfurter gade'
EXEC sp_AddCustomer NULL, 'Lærke', '82427112', 'EmailCool@gmx.net', '6440', 'Hobedgade'

-- Test for sp_DeleteCustomer
GO
EXEC sp_DeleteCustomer 1

-- Test for sp_AddAutoCamperStatus
GO
EXEC sp_InsertAutoCamperStatus 'ReadyWRONG'
EXEC sp_InsertAutoCamperStatus 'ReadyWRONG2'
EXEC sp_InsertAutoCamperStatus 'Ready'
EXEC sp_InsertAutoCamperStatus 'Rented out'
EXEC sp_InsertAutoCamperStatus 'Need Cleaning'
EXEC sp_InsertAutoCamperStatus 'Need Repairs'
EXEC sp_InsertAutoCamperStatus 'Need Refueling'
EXEC sp_InsertAutoCamperStatus 'Decommissioned'

-- Test for sp_UpdateAutoCamperStatus
GO
EXEC sp_UpdateAutoCamperStatus 'ReadyWRONG', 'Delete1'
EXEC sp_UpdateAutoCamperStatus 'ReadyWRONG2', 'Delete2'

-- Test for sp_DeleteAutoCamperStatus
GO
EXEC sp_DeleteAutoCamperStatus 'Delete1'
EXEC sp_DeleteAutoCamperStatus 'Delete2'

-- Test for sp_AddAutoCamperType
GO
EXEC sp_InsertAutoCamperType null, 'Luxury', 999.99, 799.99
EXEC sp_InsertAutoCamperType null, 'Standard', 399.99, 299.99
EXEC sp_InsertAutoCamperType null, 'Basic', 399.99, 199.99
EXEC sp_InsertAutoCamperType null, 'SHOULD BE DELETED', 1000, 1000

-- Test for sp_DeleteAutoCamperType

-- We really should never delete
GO
EXEC sp_DeleteAutoCamperType 'SHOULD BE DELETED'

--Test for sp_AddAutoCamper
GO
EXEC sp_AddAutoCamper null,'123456', 2, 370, 420, 3500, 2, 4, 2415, 'Motor stuff', 6, 'Diesel', 'TEXT OF KITCHEN',
     'TEXT OF HEATING', 'TEXT OF MEDIA', 'TEXT ABOUT GENERAL STUFF'
EXEC sp_AddAutoCamper null,'abcdgf', 1, 370, 420, 3500, 2, 4, 2415, 'Motor stuff', 6, 'Diesel', 'TEXT OF KITCHEN',
     'TEXT OF HEATING', 'TEXT OF MEDIA', 'TEXT ABOUT GENERAL STUFF'

--Test for sp_DeleteAutoCamper

-- Test for Removal of singe relation

-- Test for Removal of status to autoCamper relation

-- Test for creation of relation between status and autoCamper
GO
EXEC sp_InsertStatusToAutoCamperRelation 'Ready', 1
EXEC sp_InsertStatusToAutoCamperRelation 'Need Cleaning', 2
EXEC sp_InsertStatusToAutoCamperRelation 'Need Repairs', 2


-- Test for sp_InsertSeason WORKS
GO
EXEC sp_InsertSeason null, 1,6,7,12
EXEC sp_InsertSeason null, 4,7,8,19 --Should be deleted

-- Test for sp_DeleteSeason WORKS
GO
EXEC sp_DeleteSeason 2

-- Test for sp_AddReservation WORKS
GO
EXEC sp_AddReservation null, '2001-05-05', '2008-10-10', 500, 600, 1, 1
EXEC sp_AddReservation null, '2008-11-11', '2008-12-12', 8, 9, 2, 1
EXEC sp_AddReservation 15, '2009-01-12', '2099-12-01', 4, 5, 2, 1 --Should be deleted

-- Test for sp_DeleteReservation WORKS
GO
EXEC sp_DeleteReservation 15

-- Test for sp_DeleteCustomerToReservationRelation

-- Test for sp_RemoveCustomersFromReservation

-- Test for sp_RemoveReservationFromCustomer

-- Test for sp_InsertCustomerReservationRelation
EXEC sp_InsertCustomerReservationRelation 2, 1
EXEC sp_InsertCustomerReservationRelation 3, 2


-- Test for sp_InsertBillStatus WORKS
GO
EXEC sp_InsertBillStatus 'PAID'
EXEC sp_InsertBillStatus 'UNPAID' --Should be updated
EXEC sp_InsertBillStatus 'REFUNDED' --Should be deleted

-- Test for sp_UpdateBillStatus WORKS
GO
EXEC sp_UpdateBillStatus 'UNPAID', 'STILLUNPAID'

-- Test for sp_DeleteBillStatus WORKS
GO
EXEC sp_DeleteBillStatus 'REFUNDED'

-- Test for sp_InsertDiscount WORKS
GO
EXEC sp_InsertDiscount null, 200, 20.00001
EXEC sp_InsertDiscount null, 500, 40.8
EXEC sp_InsertDiscount null, 2, 99.99999 --Should be deleted

-- Test for sp_DeleteDiscount WORKS
GO
EXEC sp_DeleteDiscount 3

-- Test for sp_InsertInsurance WORKS
GO
EXEC sp_InsertInsurance null, 'Basic insurance', 300.50, 150.75, 'This is the desciption of the basic insurance'
EXEC sp_InsertInsurance null, 'Total insurance', 400.50, 300.75, 'This is the desciption of the Total insurance' --should be deleted

-- Test for sp_DeleteInsurance WORKS
GO
EXEC sp_DeleteInsurance 'Total insurance'

-- Test for sp_InsertFee WORKS
GO
EXEC sp_InsertFee null, 'This is a fee', 300.50
EXEC sp_InsertFee null, 'This is a fee for deletion', 9999.99

-- Test for sp_DeleteFee WORKS
GO
EXEC sp_DeleteFee 'This is a fee for deletion'

-- Test for sp_AddBill WORKS
GO
EXEC sp_AddBill null, '2008-01-01', 1, 'PAID'
EXEC sp_AddBill null, '2009-01-01', 2, 'PAID' --Should be deleted

-- Test for sp_DeleteBill WORKS
GO
EXEC sp_DeleteBill 2

-- Test for sp_InsertBillInsuranceBridge
EXEC sp_InsertBillInsuranceBridge 1, 1


-- Test for sp_RemoveInsuranceFromBill

-- Test for sp_RemoveBillFromInsurance

-- Test for sp_DeleteBillInsuranceBridge

-- Test for sp_InsertBillFeeRelation
EXEC sp_InsertBillFeeRelation 1, 1

-- Test for sp_RemoveBillsFromFee

-- Test for sp_DeleteBillFeeRelation

-- Test for sp_AddPayment WORK
EXEC sp_AddPayment null, '1999-01-01', 500.50, 1
EXEC sp_AddPayment null, '2000-01-01', 500.90, 1

-- Test for sp_DeletePayment
EXEC sp_DeletePayment 2

-- Test for sp_AddCustomFee WORKS
EXEC sp_AddCustomFee null, 500.5, 'Name', 'This is a comment', 1
EXEC sp_AddCustomFee null, 500.5, 'Name2', 'This is a comment2', 1

-- Test for sp_DeleteCustomFee WORKS
EXEC sp_DeleteCustomFee 2

-- Test for sp_InsertBillReservationRelation
EXEC sp_InsertBillReservationRelation 1, 1

-- Test for sp_RemoveBillsFromReservation

-- Test for sp_RemoveReservationsFromBill

-- Test for sp_DeleteBillReservationRelation