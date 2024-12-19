-- Recipe Steps for 'Insalata di Quinoa e Avocado'
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
((SELECT id FROM recipes WHERE title = 'Insalata di Quinoa e Avocado'),
(SELECT id FROM ingredients WHERE name = 'Quinoa'), 'Cuocere la quinoa in acqua salata secondo le istruzioni sulla confezione.', 1, 'quinoa_cottura.jpg'),
((SELECT id FROM recipes WHERE title = 'Insalata di Quinoa e Avocado'),
(SELECT id FROM ingredients WHERE name = 'Avocado'), 'Tagliare l''avocado a cubetti', 2, 'avocado_tagliato.jpg'),
((SELECT id FROM recipes WHERE title = 'Insalata di Quinoa e Avocado'),
(SELECT id FROM ingredients WHERE name = 'Limone'), 'Condire l''avocado con limone e sale', 3, 'avocado_tagliato.jpg'),
((SELECT id FROM recipes WHERE title = 'Insalata di Quinoa e Avocado'),
(SELECT id FROM ingredients WHERE name = 'Sale'), 'Aggiungere sale all''avocado e limone', 4, 'avocado_tagliato.jpg'),
((SELECT id FROM recipes WHERE title = 'Insalata di Quinoa e Avocado'),
(SELECT id FROM ingredients WHERE name = 'Pomodoro'), 'Tagliare i pomodorini e aggiungerli alla quinoa cotta.', 5, 'pomodorini_quinoa.jpg'),
((SELECT id FROM recipes WHERE title = 'Insalata di Quinoa e Avocado'),
(SELECT id FROM ingredients WHERE name = 'Olio d''oliva'), 'Mescolare tutti gli ingredienti in una ciotola e condire con olio d''oliva.', 6, 'insalata_mista.jpg'),

-- Recipe Steps for 'Pollo al Curry'
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
((SELECT id FROM recipes WHERE title = 'Pollo al Curry'),
(SELECT id FROM ingredients WHERE name = 'Pollo'), 'Tagliare il pollo a cubetti e rosolarlo in una padella con olio d''oliva.', 1, 'pollo_rosolato.jpg'),
((SELECT id FROM recipes WHERE title = 'Pollo al Curry'),
(SELECT id FROM ingredients WHERE name = 'Olio d''oliva'), 'Rosolare il pollo in una padella con olio d''oliva.', 2, null),
((SELECT id FROM recipes WHERE title = 'Pollo al Curry'),
(SELECT id FROM ingredients WHERE name = 'Cipolla'), 'Aggiungere la cipolla tritata e cuocerla fino a doratura.',3, 'cipolla_rossa.jpg'),
((SELECT id FROM recipes WHERE title = 'Pollo al Curry'),
(SELECT id FROM ingredients WHERE name = 'Curry'), 'Aggiungere la pasta di curry e mescolare bene.', 4, 'pasta_curry.jpg'),
((SELECT id FROM recipes WHERE title = 'Pollo al Curry'),
(SELECT id FROM ingredients WHERE name = 'Latte di cocco'), 'Versare il latte di cocco e cuocere per 20 minuti.', 5, 'pollo_salsa.jpg'),
((SELECT id FROM recipes WHERE title = 'Pollo al Curry'),
(SELECT id FROM ingredients WHERE name = 'Riso basmati'), 'Servire con riso basmati cotto.', 6, 'pollo_riso.jpg'),

-- Recipe Steps for 'Tiramisu'
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
((SELECT id FROM recipes WHERE title = 'Tiramisu'),
(SELECT id FROM ingredients WHERE name = 'Caffè'), 'Preparare il caffè e lasciarlo raffreddare.', 1, 'caffe_preparato.jpg'),
((SELECT id FROM recipes WHERE title = 'Tiramisu'),
(SELECT id FROM ingredients WHERE name = 'Uova'), 'Prendere le uova.', 2, 'tuorli_zucchero.jpg'),
((SELECT id FROM recipes WHERE title = 'Tiramisu'),
(SELECT id FROM ingredients WHERE name = 'Zucchero'), 'Sbattere i tuorli con lo zucchero fino a ottenere un composto cremoso.', 3, 'tuorli_zucchero.jpg'),
((SELECT id FROM recipes WHERE title = 'Tiramisu'),
(SELECT id FROM ingredients WHERE name = 'Mascarpone'), 'Aggiungere il mascarpone e mescolare fino a ottenere una crema omogenea.', 4, 'crema_mascarpone.jpg'),
((SELECT id FROM recipes WHERE title = 'Tiramisu'),
(SELECT id FROM ingredients WHERE name = 'Savoiardi'), 'Inzuppare i savoiardi nel caffè e disporli in una teglia.', 5, 'savoiardi_inzuppati.jpg'),
((SELECT id FROM recipes WHERE title = 'Tiramisu'),
null , 'Stendere la crema ottenuta sopra i savoiardi e ripetere il processo.', 6, 'tiramisu_strati.jpg'),
((SELECT id FROM recipes WHERE title = 'Tiramisu'),
(SELECT id FROM ingredients WHERE name = 'Cacao in polvere'), 'Spolverare con cacao in polvere e refrigerare per almeno 2 ore.', 7, 'tiramisu_freddo.jpg'),

-- Recipe Steps for 'Smoothie al Mango'
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
((SELECT id FROM recipes WHERE title = 'Smoothie al Mango'),
(SELECT id FROM ingredients WHERE name = 'Mango'), 'Sbucciare il mango e tagliarlo a pezzi. Aggiungerlo in un frullatore', 1, 'mango_tagliato.jpg'),
((SELECT id FROM recipes WHERE title = 'Smoothie al Mango'),
(SELECT id FROM ingredients WHERE name = 'Yogurt greco'), 'Aggiungere lo yogurt greco nel frullatore.', 2, 'mango_frullato.jpg'),
((SELECT id FROM recipes WHERE title = 'Smoothie al Mango'),
(SELECT id FROM ingredients WHERE name = 'Miele'), 'Aggiungere il miele nel frullatore e frullare finché non si ottiene una consistenza liscia.', 3, null),

-- Recipe Steps for 'Lasagne Vegetariane'
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Melanzana'), 'Grigliare le verdure (melanzane, zucchine, peperoni).', 1, 'verdure_grigliate.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Zucchina'), 'Grigliare le verdure (melanzane, zucchine, peperoni).', 2, 'verdure_grigliate.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Peperone'), 'Grigliare le verdure (melanzane, zucchine, peperoni).', 3, 'verdure_grigliate.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Latte'), 'Preparare la besciamella con latte, burro e farina.', 4, 'besciamella.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Burro'), 'Preparare la besciamella con latte, burro e farina.', 5, 'besciamella.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Farina'), 'Preparare la besciamella con latte, burro e farina.', 6, 'besciamella.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Pasta'), 'Cuocere la pasta per lasagne in acqua salata.', 7, 'pasta_lasagne.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
(SELECT id FROM ingredients WHERE name = 'Mozzarella'), 'Alternare strati di pasta, verdure, besciamella e mozzarella.', 8, 'lasagne_strati.jpg'),
((SELECT id FROM recipes WHERE title = 'Lasagne Vegetariane'),
null, 'Cuocere in forno a 180°C per 30 minuti.', 9, 'lasagne_in_forno.jpg'),

-- Recipe Steps for 'Hummus con Verdure'
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
(SELECT id FROM ingredients WHERE name = 'Ceci'), 'Cuocere i ceci e frullarli con olio d''oliva, succo di limone e aglio.', 1, 'ceci_frullati.jpg'),
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
(SELECT id FROM ingredients WHERE name = 'Olio d''oliva'), 'Prendere l''olio d''oliva', 2, null),
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
(SELECT id FROM ingredients WHERE name = 'Limone'), 'Prendere il succo del limone', 3, null),
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
(SELECT id FROM ingredients WHERE name = 'Aglio'), 'Prendere l''aglio, frullare i ceci con l''olio, il succo di limone e l''aglio', 4, null),
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
(SELECT id FROM ingredients WHERE name = 'Carota'), 'Tagliare carote a bastoncini.', 5, 'verdure_crude.jpg'),
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
(SELECT id FROM ingredients WHERE name = 'Cetriolo'), 'Tagliare i cetrioli a bastoncini.', 6, 'verdure_crude.jpg'),
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
(SELECT id FROM ingredients WHERE name = 'Sedano'), 'Tagliare il sedano a bastoncini.', 7, 'verdure_crude.jpg'),
((SELECT id FROM recipes WHERE title = 'Hummus con Verdure'),
null, 'Servire l''hummus con le verdure fresche come accompagnamento.', 6, 'hummus_servito.jpg');



-- Recipe Steps for 'Spaghetti alla Carbonara'
INSERT INTO public.recipe_steps (recipe_id, ingredient_id, description, ordinal, step_img_url)
VALUES
((SELECT id FROM recipes WHERE title = 'Spaghetti alla Carbonara'),
(SELECT id FROM ingredients WHERE name = 'Spaghetti'), 'Cuocere gli spaghetti in acqua salata bollente.', 1, 'spaghetti_bollitura.jpg'),
((SELECT id FROM recipes WHERE title = 'Spaghetti alla Carbonara'),
(SELECT id FROM ingredients WHERE name = 'Pancetta'), 'Rosolare la pancetta in padella fino a renderla croccante.', 2, 'pancetta_rosolata.jpg'),
((SELECT id FROM recipes WHERE title = 'Spaghetti alla Carbonara'),
(SELECT id FROM ingredients WHERE name = 'Uova'), 'Sbattere le uova con il pecorino grattugiato e pepe nero.', 3, 'uova_pecorino.jpg'),
((SELECT id FROM recipes WHERE title = 'Spaghetti alla Carbonara'),
(SELECT id FROM ingredients WHERE name = 'Spaghetti'), 'Scolare gli spaghetti e mescolarli con la pancetta.', 4, 'spaghetti_pancetta.jpg'),
((SELECT id FROM recipes WHERE title = 'Spaghetti alla Carbonara'),
null, 'Unire le uova al composto di spaghetti e pancetta, mescolando velocemente.', 5, 'carbonara_montata.jpg'),