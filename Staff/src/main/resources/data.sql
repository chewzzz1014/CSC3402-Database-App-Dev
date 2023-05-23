insert into department(dept_name, address, phone) values ('Department of Computer Science',
                                                          'Fakulti Sains Komputer dan Teknologi Maklumat, Universiti Putra Malaysia, 43400 UPM Serdang, Selangor Darul Ehsan',
                                                          '013-456367875');
insert into department(dept_name, address, phone) values ('Department of Software Engineering',
                                                          'Fakulti Sains Komputer dan Teknologi Maklumat, Universiti Putra Malaysia, 43400 UPM Serdang, Selangor Darul Ehsan',
                                                          '010-8768673775');
insert into department(dept_name, address, phone) values ('Department of Multimedia',
                                                          'Fakulti Sains Komputer dan Teknologi Maklumat, Universiti Putra Malaysia, 43400 UPM Serdang, Selangor Darul Ehsan',
                                                          '012-5974378509');
insert into department(dept_name, address, phone) values ('Department of Network',
                                                          'Fakulti Sains Komputer dan Teknologi Maklumat, Universiti Putra Malaysia, 43400 UPM Serdang, Selangor Darul Ehsan',
                                                          '017-3957275895');

insert into staff(first_name, last_name, salary) values ('James', 'Dean', 10000);
insert into staff(first_name, last_name, salary) values ('Mawar', 'Adenan', 12500);
insert into staff(first_name, last_name, salary) values ('Adam', 'Gray', 17000);
insert into staff(first_name, last_name, salary) values ('Steve', 'Jobs', 25000);

update staff
set dept_id = 1
where staff_id = 1;

update staff
set dept_id = 2
where staff_id = 2;