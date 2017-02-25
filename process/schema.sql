drop table public.usergroup;
drop table public.groupright;
drop table public.right;
drop table public.group;
drop table public.user;
drop table public.userpassword;


CREATE TABLE public.userpassword (
	passwordid integer NOT NULL UNIQUE,
	password varchar(100) NOT NULL,
	createdon date NOT NULL,
	updatedon date NOT NULL,
	PRIMARY KEY (passwordid)
);

CREATE TABLE public.user (
	userid integer NOT NULL,
	name varchar(100) NOT NULL,
	firstname varchar(100) NOT NULL,
	lastname varchar(100) NOT NULL,
	createdon date NOT NULL,
	updatedon date NOT NULL,
	passwordid integer NOT NULL,
	PRIMARY KEY (userid),
	FOREIGN KEY (passwordid) REFERENCES public.userpassword(passwordid)
);

CREATE TABLE public.group (
	groupid integer NOT NULL,
	name varchar(100) NOT NULL,
	createdon date NOT NULL,
	updatedon date NOT NULL,
	PRIMARY KEY (groupid)
);

CREATE TABLE public.right (
	rightid integer NOT NULL,
	name varchar(100) NOT NULL,
	createdon date NOT NULL,
	updatedon date NOT NULL,
	PRIMARY KEY (rightid)
);

CREATE TABLE public.groupright (
	groupid integer NOT NULL,
	rightid integer NOT NULL ,
	PRIMARY KEY (groupid, rightid),
	FOREIGN KEY (groupid) REFERENCES public.group(groupid),
	FOREIGN KEY (rightid) REFERENCES public.right(rightid)
);

CREATE TABLE public.usergroup (
	groupid integer NOT NULL,
	userid integer NOT NULL ,
	PRIMARY KEY (groupid, userid),
	FOREIGN KEY (groupid) REFERENCES public.group(groupid),
	FOREIGN KEY (userid) REFERENCES public.user(userid)
);

