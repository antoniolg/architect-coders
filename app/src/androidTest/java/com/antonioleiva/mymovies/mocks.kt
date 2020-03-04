package com.antonioleiva.mymovies


val popularMovies = """
    {
        "page": 1,
        "total_results": 157710,
        "total_pages": 7886,
        "results": [
        {
            "vote_count": 1241,
            "id": 420818,
            "video": false,
            "vote_average": 7.2,
            "title": "The Lion King",
            "popularity": 373.836,
            "poster_path": "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
            "original_language": "en",
            "original_title": "The Lion King",
            "genre_ids": [
            12,
            16,
            10751,
            18,
            28
            ],
            "backdrop_path": "/1TUg5pO1VZ4B0Q1amk3OlXvlpXV.jpg",
            "adult": false,
            "overview": "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
            "release_date": "2019-07-19"
        },
        {
            "vote_count": 8218,
            "id": 299534,
            "video": false,
            "vote_average": 8.4,
            "title": "Avengers: Endgame",
            "popularity": 302.535,
            "poster_path": "/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
            "original_language": "en",
            "original_title": "Avengers: Endgame",
            "genre_ids": [
            12,
            878,
            28
            ],
            "backdrop_path": "/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg",
            "adult": false,
            "overview": "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
            "release_date": "2019-04-26"
        },
        {
            "vote_count": 27,
            "id": 566555,
            "video": false,
            "vote_average": 5.1,
            "title": "Detective Conan: The Fist of Blue Sapphire",
            "popularity": 232.134,
            "poster_path": "/86Y6qM8zTn3PFVfCm9J98Ph7JEB.jpg",
            "original_language": "ja",
            "original_title": "名探偵コナン 紺青の拳（フィスト）",
            "genre_ids": [
            16,
            28,
            18,
            9648,
            35
            ],
            "backdrop_path": "/wf6VDSi4aFCZfuD8sX8JAKLfJ5m.jpg",
            "adult": false,
            "overview": "23rd movie in the \"Detective Conan\" franchise.",
            "release_date": "2019-12-31"
        },
        {
            "vote_count": 64,
            "id": 384018,
            "video": false,
            "vote_average": 7,
            "title": "Fast & Furious Presents: Hobbs & Shaw",
            "popularity": 214.183,
            "poster_path": "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
            "original_language": "en",
            "original_title": "Fast & Furious Presents: Hobbs & Shaw",
            "genre_ids": [
            28
            ],
            "backdrop_path": "/hpgda6P9GutvdkDX5MUJ92QG9aj.jpg",
            "adult": false,
            "overview": "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
            "release_date": "2019-08-02"
        },
        {
            "vote_count": 2681,
            "id": 429617,
            "video": false,
            "vote_average": 7.8,
            "title": "Spider-Man: Far from Home",
            "popularity": 199.746,
            "poster_path": "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg",
            "original_language": "en",
            "original_title": "Spider-Man: Far from Home",
            "genre_ids": [
            28,
            12,
            878
            ],
            "backdrop_path": "/dihW2yTsvQlust7mSuAqJDtqW7k.jpg",
            "adult": false,
            "overview": "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
            "release_date": "2019-07-02"
        },
        {
            "vote_count": 7801,
            "id": 920,
            "video": false,
            "vote_average": 6.7,
            "title": "Cars",
            "popularity": 120.872,
            "poster_path": "/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
            "original_language": "en",
            "original_title": "Cars",
            "genre_ids": [
            16,
            12,
            35,
            10751
            ],
            "backdrop_path": "/a1MlbLBk5Sy6YvMbSuKfwGlDVlb.jpg",
            "adult": false,
            "overview": "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.",
            "release_date": "2006-06-09"
        },
        {
            "vote_count": 21,
            "id": 506574,
            "video": false,
            "vote_average": 7.4,
            "title": "Descendants 3",
            "popularity": 115.374,
            "poster_path": "/7G7xaUXyvEC8Q4R9ljZFN2Bu1Xf.jpg",
            "original_language": "en",
            "original_title": "Descendants 3",
            "genre_ids": [
            12,
            10751,
            10402
            ],
            "backdrop_path": "/clswpC7f3hSvJlhRnymCFY0Eqm9.jpg",
            "adult": false,
            "overview": "The teenagers of Disney's most infamous villains return to the Isle of the Lost to recruit a new batch of villainous offspring to join them at Auradon Prep.",
            "release_date": "2019-08-02"
        },
        {
            "vote_count": 2893,
            "id": 399579,
            "video": false,
            "vote_average": 6.8,
            "title": "Alita: Battle Angel",
            "popularity": 114.956,
            "poster_path": "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "original_language": "en",
            "original_title": "Alita: Battle Angel",
            "genre_ids": [
            28,
            878,
            53,
            12
            ],
            "backdrop_path": "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg",
            "adult": false,
            "overview": "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "release_date": "2019-02-14"
        },
        {
            "vote_count": 14631,
            "id": 299536,
            "video": false,
            "vote_average": 8.3,
            "title": "Avengers: Infinity War",
            "popularity": 103.714,
            "poster_path": "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "original_language": "en",
            "original_title": "Avengers: Infinity War",
            "genre_ids": [
            12,
            28,
            878
            ],
            "backdrop_path": "/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg",
            "adult": false,
            "overview": "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "release_date": "2018-04-27"
        },
        {
            "vote_count": 296,
            "id": 459992,
            "video": false,
            "vote_average": 6.8,
            "title": "Long Shot",
            "popularity": 96.978,
            "poster_path": "/m2ttWZ8rMRwIMT7zA48Jo6mTkDS.jpg",
            "original_language": "en",
            "original_title": "Long Shot",
            "genre_ids": [
            35,
            10749
            ],
            "backdrop_path": "/88r25ghJzVYKq0vaOApqEOZsQlD.jpg",
            "adult": false,
            "overview": "When Fred Flarsky reunites with and charms his first crush, Charlotte Field—one of the most influential women in the world. As Charlotte prepares to make a run for the Presidency, she hires Fred as her speechwriter and sparks fly.",
            "release_date": "2019-05-03"
        },
        {
            "vote_count": 0,
            "id": 614817,
            "video": false,
            "vote_average": 0,
            "title": "Capsized: Blood in the Water",
            "popularity": 96.848,
            "poster_path": "/7RM8ZHxORS1tF9Kq0kbOxmjMaLo.jpg",
            "original_language": "en",
            "original_title": "Capsized: Blood in the Water",
            "genre_ids": [
            18,
            10770
            ],
            "backdrop_path": null,
            "adult": false,
            "overview": "Based on the harrowing true story of an October 1982 shark encounter. After a yacht bound for Florida capsizes during an unexpected storm, its crew is left to drift for days in the chilling waters of the Atlantic where they become prey to a group of tiger sharks. With the hope of rescue dwindling, the crew must do everything in their power to survive as the sharks continue to hunt them.",
            "release_date": "2019-07-31"
        },
        {
            "vote_count": 1726,
            "id": 458156,
            "video": false,
            "vote_average": 7.1,
            "title": "John Wick: Chapter 3 – Parabellum",
            "popularity": 87.684,
            "poster_path": "/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg",
            "original_language": "en",
            "original_title": "John Wick: Chapter 3 – Parabellum",
            "genre_ids": [
            80,
            28,
            53
            ],
            "backdrop_path": "/vVpEOvdxVBP2aV166j5Xlvb5Cdc.jpg",
            "adult": false,
            "overview": "Super-assassin John Wick returns with a     ${'$'}    14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.",
            "release_date": "2019-05-17"
        },
        {
            "vote_count": 2754,
            "id": 287947,
            "video": false,
            "vote_average": 7.1,
            "title": "Shazam!",
            "popularity": 86.193,
            "poster_path": "/xnopI5Xtky18MPhK40cZAGAOVeV.jpg",
            "original_language": "en",
            "original_title": "Shazam!",
            "genre_ids": [
            28,
            35,
            14
            ],
            "backdrop_path": "/OIGX2lm5tmlCKvZUghtwHzoxxO.jpg",
            "adult": false,
            "overview": "A boy is given the ability to become an adult superhero in times of need with a single magic word.",
            "release_date": "2019-03-23"
        },
        {
            "vote_count": 6631,
            "id": 299537,
            "video": false,
            "vote_average": 7,
            "title": "Captain Marvel",
            "popularity": 84.769,
            "poster_path": "/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg",
            "original_language": "en",
            "original_title": "Captain Marvel",
            "genre_ids": [
            28,
            12,
            878
            ],
            "backdrop_path": "/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg",
            "adult": false,
            "overview": "The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.",
            "release_date": "2019-03-08"
        },
        {
            "vote_count": 148,
            "id": 466272,
            "video": false,
            "vote_average": 7.6,
            "title": "Once Upon a Time in Hollywood",
            "popularity": 82.867,
            "poster_path": "/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg",
            "original_language": "en",
            "original_title": "Once Upon a Time in Hollywood",
            "genre_ids": [
            18,
            35,
            28,
            80,
            37
            ],
            "backdrop_path": "/b82nVVhYNRgtsTFV1jkdDwe6LJZ.jpg",
            "adult": false,
            "overview": "A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood's Golden Age in 1969 Los Angeles.",
            "release_date": "2019-07-26"
        },
        {
            "vote_count": 1707,
            "id": 301528,
            "video": false,
            "vote_average": 7.7,
            "title": "Toy Story 4",
            "popularity": 82.726,
            "poster_path": "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
            "original_language": "en",
            "original_title": "Toy Story 4",
            "genre_ids": [
            12,
            16,
            35,
            10751
            ],
            "backdrop_path": "/m67smI1IIMmYzCl9axvKNULVKLr.jpg",
            "adult": false,
            "overview": "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
            "release_date": "2019-06-21"
        },
        {
            "vote_count": 854,
            "id": 373571,
            "video": false,
            "vote_average": 6.2,
            "title": "Godzilla: King of the Monsters",
            "popularity": 82.63,
            "poster_path": "/pU3bnutJU91u3b4IeRPQTOP8jhV.jpg",
            "original_language": "en",
            "original_title": "Godzilla: King of the Monsters",
            "genre_ids": [
            878,
            28
            ],
            "backdrop_path": "/uovH5k4BAEPqXqxgwVrTtqH169g.jpg",
            "adult": false,
            "overview": "Follows the heroic efforts of the crypto-zoological agency Monarch as its members face off against a battery of god-sized monsters, including the mighty Godzilla, who collides with Mothra, Rodan, and his ultimate nemesis, the three-headed King Ghidorah. When these ancient super-species - thought to be mere myths - rise again, they all vie for supremacy, leaving humanity's very existence hanging in the balance.",
            "release_date": "2019-05-31"
        },
        {
            "vote_count": 683,
            "id": 479455,
            "video": false,
            "vote_average": 5.9,
            "title": "Men in Black: International",
            "popularity": 78.845,
            "poster_path": "/dPrUPFcgLfNbmDL8V69vcrTyEfb.jpg",
            "original_language": "en",
            "original_title": "Men in Black: International",
            "genre_ids": [
            28,
            35,
            878,
            12
            ],
            "backdrop_path": "/2FYzxgLNuNVwncilzUeCGbOQzP7.jpg",
            "adult": false,
            "overview": "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.",
            "release_date": "2019-06-14"
        },
        {
            "vote_count": 1888,
            "id": 447404,
            "video": false,
            "vote_average": 7,
            "title": "Pokémon Detective Pikachu",
            "popularity": 70.101,
            "poster_path": "/wgQ7APnFpf1TuviKHXeEe3KnsTV.jpg",
            "original_language": "en",
            "original_title": "Pokémon Detective Pikachu",
            "genre_ids": [
            28,
            12,
            14
            ],
            "backdrop_path": "/nDP33LmQwNsnPv29GQazz59HjJI.jpg",
            "adult": false,
            "overview": "In a world where people collect pocket-size monsters (Pokémon) to do battle, a boy comes across an intelligent monster who seeks to be a detective.",
            "release_date": "2019-05-10"
        },
        {
            "vote_count": 2405,
            "id": 420817,
            "video": false,
            "vote_average": 7.1,
            "title": "Aladdin",
            "popularity": 62.004,
            "poster_path": "/3iYQTLGoy7QnjcUYRJy4YrAgGvp.jpg",
            "original_language": "en",
            "original_title": "Aladdin",
            "genre_ids": [
            12,
            14,
            10749,
            35,
            10751
            ],
            "backdrop_path": "/v4yVTbbl8dE1UP2dWu5CLyaXOku.jpg",
            "adult": false,
            "overview": "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
            "release_date": "2019-05-24"
        }
        ]
    }
""".trimIndent()