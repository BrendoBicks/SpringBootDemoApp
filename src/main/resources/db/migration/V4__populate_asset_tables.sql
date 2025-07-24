SET @now = now();

INSERT INTO asset_status (name, code, created_at)
VALUES
    ("Active", "A", @now),
    ("Inactive", "I", @now),
    ("Standby", "S", @now),
    ("Sold", "SLD", @now),
    ("Broken", "B", @now);

INSERT INTO asset_types (name, description, created_at)
VALUES
    ("Truck", "Pick Up", @now),
    ("Small Dump Truck", "5 Yard Dump Truck", @now),
    ("Medium Dump Truck", "15 Yard Dump Truck", @now),
    ("Large Dump Truck", "25 Yard Dump Truck", @now);

INSERT INTO assets (code, asset_status_id, asset_type_id, created_at)
VALUES
    ("Ford F-150",
     (SELECT id FROM asset_status WHERE code = 'A'),
     (SELECT id FROM asset_types WHERE name = 'Truck'),
     @now),

    ("Dumpmaster 5000",
     (SELECT id FROM asset_status WHERE code = 'S'),
     (SELECT id FROM asset_types WHERE name = 'Medium Dump Truck'),
     @now),

    ("Workhorse Mini",
     (SELECT id FROM asset_status WHERE code = 'A'),
     (SELECT id FROM asset_types WHERE name = 'Small Dump Truck'),
     @now),

    ("MegaHaul XL",
     (SELECT id FROM asset_status WHERE code = 'B'),
     (SELECT id FROM asset_types WHERE name = 'Large Dump Truck'),
     @now);
