CREATE TABLE library.types (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NULL
);

CREATE TABLE library.books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title NVARCHAR(255) NULL,
    author NVARCHAR(255) NULL,
    description TEXT NULL,
    year_of_publication DATETIME NULL,
    quantity INT NULL,
    price DOUBLE NULL,
    image VARCHAR(250) NULL,
    type_id INT NULL,
    FOREIGN KEY (type_id) REFERENCES library.types(id) ON DELETE CASCADE
);

CREATE TABLE library.roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NULL
);

CREATE TABLE library.users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NULL,
    username NVARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    phone NVARCHAR(50) NULL,
    email NVARCHAR(255) NULL,
    role_id INT NULL,
    FOREIGN KEY (role_id) REFERENCES library.roles(id) ON DELETE CASCADE
);

CREATE TABLE library.orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rental_date DATETIME NULL,
    return_date DATETIME NULL,
    quantity INT NULL,
    price DOUBLE NULL,
    status NVARCHAR(50) NULL,
    user_id INT NULL,
    FOREIGN KEY (user_id) REFERENCES library.users(id) ON DELETE CASCADE
);

CREATE TABLE library.order_detail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NULL,
    price DOUBLE NULL,
    order_id INT NULL,
    book_id INT NULL,
    FOREIGN KEY (order_id) REFERENCES library.orders(id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES library.books(id) ON DELETE CASCADE
);

INSERT INTO library.roles(name) 
VALUES ('admin'), ('user');

INSERT INTO library.types (name) VALUES
('Văn Học'),
('Khoa Học'),
('Lịch Sử'),
('Thiếu Nhi');

INSERT INTO library.books (title, author, description, year_of_publication, quantity, price, image, type_id) VALUES
('Truyện Kiều', 'Nguyễn Du', 'Một tác phẩm văn học nổi tiếng', '1820-01-01', 10, 120000, NULL, 1),
('Vật Lý Đại Cương', 'Nguyễn Văn A', 'Sách giáo khoa cơ bản về vật lý', '2005-06-15', 5, 85000, NULL, 2),
('Lịch Sử Việt Nam', 'Trần Văn B', 'Khám phá lịch sử Việt Nam từ xưa đến nay', '1998-12-01', 8, 150000, NULL, 3),
('Đôrêmon - Tập 1', 'Fujiko F. Fujio', 'Truyện tranh thiếu nhi nổi tiếng', '1990-07-20', 20, 45000, NULL, 4);

INSERT INTO library.users (name, username, password, phone, email, role_id) VALUES
('Nguyễn Văn A', 'admin', 'admin123', '0987654321', 'admin@example.com', 1),
('Trần Thị B', 'user1', 'user123', '0912345678', 'user1@example.com', 2);

INSERT INTO library.orders (rental_date, return_date, quantity, price, status, user_id) VALUES
('2024-12-01', '2024-12-15', 2, 300000, 'Đang Mượn', 2),
('2024-11-01', '2024-11-15', 1, 150000, 'Đã Trả', 2);

INSERT INTO library.order_detail (quantity, price, order_id, book_id) VALUES
(1, 120000, 1, 1),
(1, 180000, 1, 3),
(1, 150000, 2, 3);

