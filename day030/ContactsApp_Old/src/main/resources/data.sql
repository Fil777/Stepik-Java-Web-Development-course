-- скрипт автовыполнения при старте приложения
SELECT to_regclass('contacts.contact_owners') IS NOT NULL AS table_exists;
SELECT to_regclass('contacts.contacts') IS NOT NULL AS table_exists;