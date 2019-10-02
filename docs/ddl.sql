CREATE TABLE IF NOT EXISTS `Card`
(
    `card_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `created` INTEGER                           NOT NULL,
    `updated` INTEGER                           NOT NULL,
    `shoe_id` INTEGER,
    `hand_id` INTEGER,
    FOREIGN KEY (`shoe_id`) REFERENCES `Shoe` (`shoe_id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY (`hand_id`) REFERENCES `Hand` (`hand_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX `index_Card_created` ON `Card` (`created`);

CREATE INDEX `index_Card_updated` ON `Card` (`updated`);

CREATE INDEX `index_Card_shoe_id` ON `Card` (`shoe_id`);
