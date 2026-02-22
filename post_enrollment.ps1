$body = @{
    enrollmentDate = "2026-02-20T10:30:00"
    student = @{
        idStudent = 12
    }
    enrollmentDetail = @(
        @{
            course = @{
                idCourse = 1
            }
            classroom = "Aula 101"
        }
    )
    status = $true
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:9494/v1/enrollments" `
    -Method Post `
    -ContentType "application/json" `
    -Body $body `
    -Verbose

