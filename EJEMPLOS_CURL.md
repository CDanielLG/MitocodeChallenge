# Ejemplos de cURL para Insertar Datos en EnrollmentRegister

## 1. Crear un Estudiante

```bash
curl -X POST http://localhost:8080/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan",
    "lastName": "Pérez",
    "dni": "12345678",
    "age": 20
  }'
```

**Respuesta esperada:**
```json
{
  "idStudent": 1,
  "name": "Juan",
  "lastName": "Pérez",
  "dni": "12345678",
  "age": 20
}
```

---

## 2. Crear un Curso

```bash
curl -X POST http://localhost:8080/v1/courses \
  -H "Content-Type: application/json" \
  -d '{
    "nameOfCourse": "Programación en Java",
    "initialisms": "JAVA",
    "state": true
  }'
```

**Respuesta esperada:**
```json
{
  "idCourse": 1,
  "nameOfCourse": "Programación en Java",
  "initialisms": "JAVA",
  "state": true
}
```

---

## 3. Crear otro Curso

```bash
curl -X POST http://localhost:8080/v1/courses \
  -H "Content-Type: application/json" \
  -d '{
    "nameOfCourse": "Base de Datos",
    "initialisms": "BD",
    "state": true
  }'
```

---

## 4. Registrar Matrícula del Estudiante

```bash
curl -X POST http://localhost:8080/v1/enrollments \
  -H "Content-Type: application/json" \
  -d '{
    "enrollmentDate": "2025-02-20T10:30:00",
    "student": {
      "idStudent": 1
    },
    "enrollmentDetail": [
      {
        "course": {
          "idCourse": 1
        },
        "classroom": "Aula 101"
      },
      {
        "course": {
          "idCourse": 2
        },
        "classroom": "Laboratorio 1"
      }
    ],
    "status": true
  }'
```

**Respuesta esperada:**
```json
{
  "idEnrollmentRegister": 1,
  "enrollmentDate": "2025-02-20T10:30:00",
  "student": {
    "idStudent": 1,
    "name": "Juan",
    "lastName": "Pérez",
    "dni": "12345678",
    "age": 20
  },
  "enrollmentDetail": [
    {
      "idEnrollmentDetail": 1,
      "course": {
        "idCourse": 1,
        "nameOfCourse": "Programación en Java",
        "initialisms": "JAVA",
        "state": true
      },
      "classroom": "Aula 101"
    },
    {
      "idEnrollmentDetail": 2,
      "course": {
        "idCourse": 2,
        "nameOfCourse": "Base de Datos",
        "initialisms": "BD",
        "state": true
      },
      "classroom": "Laboratorio 1"
    }
  ],
  "status": true
}
```

---

## 5. Listar Todas las Matrículas

```bash
curl -X GET http://localhost:8080/v1/enrollments \
  -H "Content-Type: application/json"
```

---

## 6. Obtener una Matrícula por ID

```bash
curl -X GET http://localhost:8080/v1/enrollments/1 \
  -H "Content-Type: application/json"
```

---

## 7. Actualizar una Matrícula

```bash
curl -X PUT http://localhost:8080/v1/enrollments/1 \
  -H "Content-Type: application/json" \
  -d '{
    "enrollmentDate": "2025-02-21T14:00:00",
    "student": {
      "idStudent": 1
    },
    "enrollmentDetail": [
      {
        "course": {
          "idCourse": 1
        },
        "classroom": "Aula 201"
      }
    ],
    "status": true
  }'
```

---

## 8. Eliminar una Matrícula

```bash
curl -X DELETE http://localhost:8080/v1/enrollments/1 \
  -H "Content-Type: application/json"
```

---

## 9. Actualizar el Aula de una Matrícula (ID 30)

```bash
curl -X PUT http://localhost:9494/v1/enrollments/30 \
  -H "Content-Type: application/json" \
  -d '{
    "enrollmentDate": "2026-02-21T10:00:00",
    "student": {
      "idStudent": 1
    },
    "enrollmentDetail": [
      {
        "course": {
          "idCourse": 1
        },
        "classroom": "A101"
      }
    ],
    "status": true
  }'
```

---

## Notas Importantes

1. **Base URL**: Cambia `http://localhost:8080` por tu URL de servidor si es diferente
2. **Estudiante**: Solo necesita el `idStudent` en el JSON
3. **Curso**: En `enrollmentDetail`, el curso solo necesita el `idCourse`
4. **Aula**: Es el nombre del aula donde se imparte la clase
5. **Fecha**: Debe estar en formato ISO 8601 (YYYY-MM-DDTHH:mm:ss)
6. **Estado**: `true` para activo, `false` para inactivo

## Flujo Recomendado

1. ✅ Crear al menos un estudiante
2. ✅ Crear al menos dos cursos
3. ✅ Registrar una matrícula con múltiples cursos
4. ✅ Verificar consultando la matrícula
5. ✅ Actualizar si es necesario
6. ✅ Eliminar cuando sea requerido

