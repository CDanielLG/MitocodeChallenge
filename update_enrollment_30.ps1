curl.exe -X PUT "http://localhost:9494/v1/enrollments/30" `
     -H "Content-Type: application/json" `
     -d '{ \"idEnrollmentRegister\": 30, \"enrollmentDate\": \"2026-02-21T10:00:00\", \"student\": { \"idStudent\": 1 }, \"status\": true, \"enrollmentDetail\": [ { \"course\": { \"idCourse\": 1 }, \"classroom\": \"A101\" } ] }'
