-- Inserimento ricetta Spaghetti alla Carbonara
INSERT INTO public.recipes (title, description, category, prep_time, cooking_time, difficulty, kCalories, creation_date, tag, user_id)
VALUES
('Spaghetti alla Carbonara', 'Un classico piatto romano a base di spaghetti, uova, pancetta, formaggio pecorino e pepe nero.', 'primo', 10, 15, 'facile', 600, CURRENT_DATE, 'tradizionale', 1);

-- Inserimento ingredienti e passaggi
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
(1, (SELECT id FROM public.ingredients WHERE name = 'Spaghetti'), 'Cuocere gli spaghetti in abbondante acqua salata.', 1, NULL),
(1, (SELECT id FROM public.ingredients WHERE name = 'Pancetta'), 'Rosolare la pancetta in una padella fino a farla diventare croccante.', 2, NULL),
(1, (SELECT id FROM public.ingredients WHERE name = 'Uovo'), 'Sbattere le uova con il formaggio pecorino grattugiato e pepe nero.', 3, NULL),
(1, (SELECT id FROM public.ingredients WHERE name = 'Pecorino'), 'Aggiungere il pecorino grattugiato al composto di uova e mescolare bene.', 4, NULL),
(1, (SELECT id FROM public.ingredients WHERE name = 'Pepe Nero'), 'Aggiungere una generosa dose di pepe nero nel composto di uova.', 5, NULL),
(1, (SELECT id FROM public.ingredients WHERE name = 'Spaghetti'), 'Scolare gli spaghetti e unirli alla pancetta croccante nella padella.', 6, NULL),
(1, (SELECT id FROM public.ingredients WHERE name = 'Uovo'), 'Versare il composto di uova e formaggio sugli spaghetti, mescolando velocemente per evitare che l\'uovo cuocia troppo.', 7, NULL);