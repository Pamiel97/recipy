--Creazione tabella users
DROP TABLE IF EXISTS pantries CASCADE;
DROP TABLE IF EXISTS user_intolerances CASCADE;
DROP TABLE IF EXISTS user_allergies CASCADE;
DROP TABLE IF EXISTS recipe_tags CASCADE;
DROP TABLE IF EXISTS intolerances CASCADE;
DROP TABLE IF EXISTS allergies CASCADE;
DROP TABLE IF EXISTS tags CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS recipe_steps CASCADE;
DROP TABLE IF EXISTS recipes CASCADE;
DROP TABLE IF EXISTS ingredients CASCADE;
DROP TABLE IF EXISTS users CASCADE;


CREATE TABLE public.users
(
    id bigint generated by default as identity,
    firstname character varying(64) NOT NULL,
    lastname character varying(64) NOT NULL,
    email character varying(128) NOT NULL,
    password character varying(128) NOT NULL,
    sex character(1),
    profile character varying(64),
    weight real,
    height real,
    bfp real,
    lbmp real,
    diet_type character varying(64),
    pal character varying(64),
    img_url character varying(64),
    role character varying(32),
    PRIMARY KEY (id),
    CONSTRAINT check_bfp_range CHECK (bfp>=0 AND bfp<=1),
    CONSTRAINT check_lbmp_range CHECK (lbmp>=0 AND lbmp<=1),
    CONSTRAINT check_profile CHECK (profile IN('utente_base', 'chef', 'dietologo', 'altro')),
    CONSTRAINT check_diet_type CHECK (diet_type IN('vegano', 'vegetariano', 'pescatariano', 'onnivoro', 'carnivoro', 'fruttariano', 'altro')),
    CONSTRAINT check_pal CHECK (pal IN('sedentario', 'leggero', 'moderato', 'intenso'))
);

--Creazione tabella ricette
CREATE TABLE public.recipes
(
    id bigint generated by default as identity,
    title character varying(128) NOT NULL,
    description character varying(500),
    course character varying(64),
    prep_time bigint,
    cooking_time bigint,
    difficulty character varying(64),
    kCalories real,
    creation_date date,
    tag character varying(64),
    img_url character varying(32),
    user_id bigint,
    PRIMARY KEY (id),
    CONSTRAINT fk_recipes_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT check_course CHECK (course IN('antipasto', 'primo', 'secondo', 'dolce', 'bevanda', 'contorno', 'snack')),
    CONSTRAINT check_difficulty CHECK (difficulty IN('facile', 'medio', 'difficile')),
    CONSTRAINT check_tag CHECK (tag IN('veloce', 'estivo', 'gustoso', 'piccante', 'tradizionale', 'sano'))
);

--Creazione tabella reviews
CREATE TABLE public.reviews
(
    id bigint generated by default as identity,
    text character varying(500),
    rating real NOT NULL,
    creation_date date NOT NULL DEFAULT current_date,
    user_id bigint NOT NULL,
    recipe_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_reviews_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_reviews_recipe FOREIGN KEY (recipe_id) REFERENCES recipes (id),
    CONSTRAINT check_rating CHECK (rating >= 0 AND rating <= 5)
);

CREATE TABLE public.tags
(
    id bigint generated by default as identity,
    name character varying(32),
    recipe_id bigint NOT NULL,
    PRIMARY KEY (id)
    CONSTRAINT "fk_tags_recipeId" FOREIGN KEY (recipe_id)
    REFERENCES public.recipes (id) MATCH SIMPLE
);

CREATE TABLE public.recipe_tags
(
    id bigint generated by default as identity,
    recipe_id bigint NOT NULL,
    tag_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_recipe_tag_recipe FOREIGN KEY (recipe_id) REFERENCES recipes (id),
    CONSTRAINT fk_recipe_tag_tag FOREIGN KEY (tag_id) REFERENCES tags (id)
);

CREATE TABLE public.allergies
(
    id bigint generated by default as identity,
    name character varying(32),
    PRIMARY KEY (id)
);

CREATE TABLE public.intolerances
(
    id bigint generated by default as identity,
    name character varying(16),
    PRIMARY KEY (id)
);

-- Creazione tabella ingredienti
CREATE TABLE public.ingredients
(
    id bigint generated by default as identity,
    name character varying(128) NOT NULL,
    kcal_per_gram real NOT NULL,
    carbohydrates_per_gram real NOT NULL,
    proteins_per_gram real NOT NULL,
    fats_per_gram real NOT NULL,
    category character varying(64),
    avg_weight real,
    avg_price real,
    img_url character varying(64),
    diet_compatibility character varying(32),
    allergy_id bigint,
    intolerance_id bigint,
    PRIMARY KEY (id),
    CONSTRAINT check_category CHECK (category IN('frutta', 'verdura', 'cereali', 'legumi', 'carne', 'pesce', 'uova', 'latticini', 'frutta_secca_e_semi', 'grassi', 'dolci_e_zuccheri', 'bevande', 'altro')),
    CONSTRAINT fk_ingredients_allergy FOREIGN KEY (allergy_id) REFERENCES allergies (id),
    CONSTRAINT fk_ingredients_intolerance FOREIGN KEY (intolerance_id) REFERENCES intolerances (id),
    CONSTRAINT check_diet_compatibility CHECK (diet_compatibility IN('vegano', 'vegetariano', 'pescatariano', 'onnivoro', 'carnivoro', 'fruttariano',  'altro'))
);

ALTER TABLE IF EXISTS public.ingredients
    OWNER to postgres;

CREATE TABLE public.user_allergies
(
    id bigint generated by default as identity,
    user_id bigint NOT NULL,
    allergy_id bigint NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_user_allergies_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_user_allergies_allergy FOREIGN KEY (allergy_id) REFERENCES allergies (id)
);

CREATE TABLE public.user_intolerances
(
    id bigint generated by default as identity,
    user_id bigint NOT NULL,
    intolerance_id bigint NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_user_intolerances_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_user_intolerances_intolerance FOREIGN KEY (intolerance_id) REFERENCES intolerances (id)
);

CREATE TABLE public.pantries
(
    id bigint generated by default as identity,
    quantity int NOT NULL,
    unit_type character varying(32),
    purchase_date date,
    expiration_date date,
    user_id bigint NOT NULL,
    ingredient_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT check_unit_type CHECK (unit_type IN('gr', 'l', 'pz')),
    CONSTRAINT fk_pantry_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_pantry_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);

CREATE TABLE public.recipe_steps
(
    id bigint generated by default as identity,
    recipe_id bigint NOT NULL,
    ingredient_id bigint,
    description character varying(128) NOT NULL,
    ordinal int NOT NULL,
    step_img_url character varying(32),
    PRIMARY KEY (id),
    CONSTRAINT fk_recipe_steps_recipes FOREIGN KEY (recipe_id) REFERENCES recipes (id),
    CONSTRAINT fk_recipe_steps_ingredients FOREIGN KEY (ingredient_id) REFERENCES ingredients (id),
    CONSTRAINT check_ordinal_positive CHECK (ordinal>0)
);