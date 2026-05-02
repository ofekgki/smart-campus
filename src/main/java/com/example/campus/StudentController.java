package com.example.campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // עובד ומוכן: שליפת כל הסטודנטים
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // עובד ומוכן: יצירת סטודנט חדש
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // =========================================================
    // TODO: משימות השלמה לסטודנטים
    // =========================================================

    // --- TODO משימה 1: מחיקת סטודנט ---
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        // 1. בדקו האם הסטודנט קיים ב-DB בעזרת studentRepository
        // 2. אם לא קיים, החזירו שגיאת 404 (NotFound)
        // 3. אם קיים, מחקו אותו והחזירו הודעת הצלחה (200 OK)

        return ResponseEntity.status(501).body("מחיקה טרם מומשה בשרת!");
    }

    // --- TODO משימה 2: עדכון ציון (PUT) ---
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentGrade(@PathVariable Long id, @RequestBody Student updatedData) {
        // 1. חפשו את הסטודנט לפי ה-id שהתקבל ב-URL
        // 2. אם הוא לא קיים, החזירו 404
        // 3. אם קיים, שנו *רק* את הציון שלו לציון החדש שהגיע ב-updatedData
        // 4. שמרו את הסטודנט המעודכן ל-DB והחזירו אותו ללקוח

        return ResponseEntity.status(501).body("עדכון ציון טרם מומש בשרת!");
    }

    // --- TODO משימה 3: שליפת נכשלים ---
    @GetMapping("/failing")
    public List<Student> getFailingStudents() {
        // 1. השתמשו בפונקציה שיצרתם ב-StudentRepository כדי לשלוף רק סטודנטים עם ציון מתחת ל-60
        // 2. החזירו את הרשימה

        return new ArrayList<>(); // כרגע מחזיר רשימה ריקה
    }

    // --- TODO משימה 4: מיון לפי ציון מהשרת ---
    @GetMapping("/sorted")
    public List<Student> getSortedStudents() {
        // 1. השתמשו בפונקציית findAll אבל העבירו לה אובייקט מסוג Sort
        // 2. מיינו את התוצאות לפי העמודה "grade" בסדר יורד (DESC) או עולה (ASC)
        // רמז: studentRepository.findAll(Sort.by(Sort.Direction.DESC, "grade"))

        return new ArrayList<>(); // כרגע מחזיר רשימה ריקה
    }
}