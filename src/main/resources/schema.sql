DROP TABLE IF EXISTS `Book`;

CREATE TABLE Book (
                          id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                          title varchar(80) NOT NULL,
                          description varchar(200) NOT NULL,
                          author varchar(40) NOT NULL,
                          publish_date TIMESTAMP
);

INSERT INTO Book (title, description, author, publish_date) VALUES
                                                                ('OCP：Java SE 11 Developer 認證指南（上）物件導向設計篇', '上冊以基本語法入門，以至於了解封裝、繼承、多型等物件導向程式的撰寫方式與設計模式實作，也包含列舉型別、巢狀類別、lamdba表示式等特殊語法講授。', '曾瑞君', now()),
                                                                ('Java SE 17基礎必修課(適用Java 17~10，涵蓋ITS Java國際認證)', '扎實Java程式設計訓練，培養程式設計與運算思維能力，為您打下輕鬆考取ITS Java國際認證能力! ', '蔡文龍, 何嘉益, 張志成, 張力元', now()),
                                                                ('最實用業界專案精選：用Spring Boot和Spring Cloud頂級開發', '隨著微服務概念的興起，如何快速實施微服務成了一個重要話題。在Java服務端領域，Spring Cloud微服務系統事實上已經成為整個Java後端架構的標準配備。', '姜橋', now());