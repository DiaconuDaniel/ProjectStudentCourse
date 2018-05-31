ProjectStudentCourse

Api-ul StudentCurs este bazat pe o arhitectura REST care prezinta o legatura de many-to-many intre student si un curs.
Api-ul pune la dispozitie urmatoarele functionalitati.
a)Pentru entitatea de tip Student :
	- adaugare student : http://localhost:8080/student/add
	- afisare toti studentii: http://localhost:8080/student/all
	- afisare doar un singur student : http://localhost:8080/student/1
	- update student: http://localhost:8080/student/update/1
	- metoda pentru a adauga unui student un anumit curs(many-to-many): http://localhost:8080/student/1/addCourse
	
b)Pentru entitatea de tip Curs:
	- adaugare curs : http://localhost:8080/course/add
	- afisare toate cursurile: http://localhost:8080/course/all
	- afisare doar un singur curs : http://localhost:8080/course/1
	- update curs: http://localhost:8080/course/update/1
	- metoda pentru a adauga unui curs un anumit student(many-to-many): http://localhost:8080/course/1/addStudent
	
Api-ul poate fi testat cu ajutorul lui Postman.

