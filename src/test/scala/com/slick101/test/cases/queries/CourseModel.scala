package com.slick101.test.cases.queries

import slick.jdbc.H2Profile.api._

object CourseModel {

  // student
  case class Student(name: String,
                     middleName: Option[String],
                     surname: String,
                     nationality: String,
                     id: Long = -1L)

  class StudentTable(tag: Tag) extends Table[Student](tag, "STUDENT") {
    def name = column[String]("NAME")
    def middleName = column[Option[String]]("MIDDLE_NAME")
    def surname = column[String]("SURNAME")
    def nationality = column[String]("NATIONALITY")
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def * = (name, middleName, surname, nationality, id) <> (Student.tupled, Student.unapply)
  }

  lazy val StudentTable = TableQuery[StudentTable]

  // document
  case class Document(studentId: Long,
                      name: String,
                      uuid: String,
                      id: Long = -1L)

  class DocumentTable(tag: Tag) extends Table[Document](tag, "DOCUMENT") {
    def studentId = column[Long]("STUDENTID")
    def name = column[String]("NAME")
    def uuid = column[String]("UUID")
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def * = (studentId, name, uuid, id) <> (Document.tupled, Document.unapply)

    def student = foreignKey("fk_document_student", studentId, StudentTable)(_.id)
  }

  lazy val DocumentTable = TableQuery[DocumentTable]

  // course
  case class Course(name: String,
                    id: Long = -1L)

  class CourseTable(tag: Tag) extends Table[Course](tag, "COURSE") {
    def name = column[String]("NAME")
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def * = (name, id) <> (Course.tupled, Course.unapply)
  }

  lazy val CourseTable = TableQuery[CourseTable]

  // semester
  case class Semester(year: Int,
                      part: String,
                      id: Long = -1L)

  class SemesterTable(tag: Tag) extends Table[Semester](tag, "SEMESTER") {
    def year = column[Int]("YEAR")
    def part = column[String]("PART")
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def * = (year, part, id) <> (Semester.tupled, Semester.unapply)
  }

  lazy val SemesterTable = TableQuery[SemesterTable]

  // student course segment
  case class StudentCourseSegment(studentId: Long,
                                  courseId: Long,
                                  semesterId: Long,
                                  id: Long = -1L)

  class StudentCourseSegmentTable(tag: Tag) extends Table[StudentCourseSegment](tag, "STUDENT_COURSE_SEGMENT") {
    def studentId = column[Long]("STUDENT_ID")
    def courseId = column[Long]("COURSE_ID")
    def semesterId = column[Long]("SEMESTER_ID")
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def * = (studentId, courseId, semesterId, id) <> (StudentCourseSegment.tupled, StudentCourseSegment.unapply)

    def student = foreignKey("fk_segment_student", studentId, StudentTable)(_.id)
    def course = foreignKey("fk_segment_course", studentId, CourseTable)(_.id)
    def semester = foreignKey("fk_segment_semester", studentId, SemesterTable)(_.id)
  }

  lazy val StudentCourseSegmentTable = TableQuery[StudentCourseSegmentTable]

  // grade
  case class Grade(studentCourseSegmentId: Long,
                   grade: Int,
                   id: Long = -1L)

  class GradeTable(tag: Tag) extends Table[Grade](tag, "GRADE") {
    def studentCourseSegmentId = column[Long]("STUDENT_COURSE_SEGMENT_ID")
    def grade = column[Int]("GRADE")
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def * = (studentCourseSegmentId, grade, id) <> (Grade.tupled, Grade.unapply)

    def segment = foreignKey("fk_grade_segment", studentCourseSegmentId, StudentCourseSegmentTable)(_.id)
  }

  lazy val GradeTable = TableQuery[GradeTable]
}