CREATE TABLE authors (
    author_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    author_name VARCHAR(50) NOT NULL,
    author_bio VARCHAR(500) NULL
);

CREATE TABLE books (
    book_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    book_title VARCHAR(100) NOT NULL,
    author_id UUID NOT NULL REFERENCES authors(author_id) ON DELETE CASCADE
    ON UPDATE CASCADE,
    book_published_date DATE NOT NULL,
    book_status VARCHAR(20) NOT NULL
);

CREATE TABLE users (
    user_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE borrowings (
    borrowing_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    book_id UUID NOT NULL REFERENCES books(book_id) ON DELETE CASCADE
    ON UPDATE CASCADE,
    user_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE
    ON UPDATE CASCADE,
    borrowing_date DATE NOT NULL,
    borrowing_return_date DATE NOT NULL
);