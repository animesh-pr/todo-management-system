CREATE DATABASE todo_db;
USE todo_db;

CREATE TABLE todos (
id VARCHAR(255) PRIMARY KEY,
title VARCHAR(255),
description TEXT,
completed BOOLEAN
);