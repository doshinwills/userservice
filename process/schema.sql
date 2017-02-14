CREATE TABLE public.user (
  id integer NOT NULL,
  usertype varchar(50) DEFAULT NULL,
	firstname varchar(100) NOT NULL,
	lastname varchar(100) NOT NULL,
	address varchar(500) NOT NULL,
  username varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  createdon date NOT NULL,
  updatedon date NOT NULL,
  PRIMARY KEY (id)
)
