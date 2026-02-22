# Cómo Insertar Datos en EnrollmentRegister

## Estructura JSON para POST a `/v1/enrollments`

### Ejemplo 1: Registrar una matrícula para un estudiante

```json
{
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
      "classroom": "Aula 102"
    }
  ],
  "status": true
}
```

### Ejemplo 2: Matrícula con múltiples cursos

```json
{
  "enrollmentDate": "2025-02-20T14:15:00",
  "student": {
    "idStudent": 2
  },
  "enrollmentDetail": [
    {
      "course": {
        "idCourse": 1
      },
      "classroom": "Laboratorio 1"
    },
    {
      "course": {
        "idCourse": 3
      },
      "classroom": "Aula 203"
    }
  ],
  "status": true
}
```

## Pasos para Insertar Datos:

### 1. Primero, crear un Estudiante (POST a `/v1/students`)
```json
{
  "name": "Juan",
  "lastName": "Pérez",
  "dni": "12345678",
  "age": 20
}
```

### 2. Crear Cursos (POST a `/v1/courses`)
```json
{
  "nameOfCourse": "Programación en Java",
  "initialisms": "JAVA",
  "state": true
}
```

### 3. Registrar Matrícula (POST a `/v1/enrollments`)
```json
{
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
    }
  ],
  "status": true
}
```

## Notas Importantes:

1. **Estudiante**: Solo necesita el `idStudent` (referencia a un estudiante existente)
2. **Cursos**: En `enrollmentDetail`, cada curso solo necesita el `idCourse` (referencia a un curso existente)
3. **Classroom**: Es el nombre del aula donde se imparte la clase
4. **Status**: Indica si la matrícula está activa (true) o inactiva (false)
5. **enrollmentDate**: Fecha y hora de la matrícula en formato ISO 8601

## Endpoints Disponibles:

- `GET /v1/enrollments` - Listar todas las matrículas
- `GET /v1/enrollments/{id}` - Obtener una matrícula por ID
- `POST /v1/enrollments` - Crear una nueva matrícula
- `PUT /v1/enrollments/{id}` - Actualizar una matrícula
- `DELETE /v1/enrollments/{id}` - Eliminar una matrícula

## Relaciones de Base de Datos:

```
EnrollmentRegister (1) -----> (*) EnrollmentDetail
         |
         |
         v
      Student (muchos-a-uno)

EnrollmentDetail (muchos-a-uno) -----> Course
```

La tabla `enrollment_detail` tiene:
- `id_enrollment_register` (llave foránea hacia EnrollmentRegister)
- `id_course` (llave foránea hacia Course)
- `classroom` (aula donde se imparte el curso)

