1

SELECT physician.Name
FROM physician, undergoes 
WHERE Physician.EmployeeID = undergoes.physician
AND undergoes.physician NOT IN (SELECT name FROM Procedures);

2

SELECT distinct physician.Name
FROM physician, undergoes, Procedures, Trained_in
WHERE Physician.EmployeeID = undergoes.physician
AND undergoes.procedures = procedures.code
AND procedures.code = trained_in.treatment
AND undergoes.dateundergoes > trained_in.certificationexpires;

3

--same as the previous but including the following: physician name, name of the procedure, date of the procedure was carried out, name of the patient carried  out,
--date of certification expired.

SELECT distinct physician.Name, procedures.name, procedures.code, patient.name, trained_in.certificationexpires
FROM physician, undergoes, Procedures, Trained_in, patient
WHERE Physician.EmployeeID = undergoes.physician
AND undergoes.procedures = procedures.code
AND procedures.code = trained_in.treatment
AND undergoes.dateundergoes > trained_in.certificationexpires
AND patient.ssn = undergoes.patient;

4

--OBTAIN THE NURSES WHO HAVE EVER BEEN ON CALL FOR ROOM 123

SELECT nurse.employeeid
FROM nurse, on_call, block, room
WHERE nurse.employeeid = on_call.nurse
AND on_call.blockcode = block.blockcode
AND block.blockfloor = room.blockfloor
AND room.roomnumber = 123;

