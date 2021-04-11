import org.apache.commons.codec.language.DaitchMokotoffSoundex
import java.io.File
import java.util.*


val sharedSurnames = mutableListOf("")
val sharedInLawNames = mutableListOf("")
val myFamilies = "Sternbach, Reluschin, Relyushchin, Reluskin, Rilushchin, rilustchin, relushchin, Riluschin, Rilyushchin, Riluskin, Relushin, Reluchin, Rilushin, Riluchin, Relustin, Rilustin, Relustschin, Hurvitz, Hurvit, Horvit, Hurwitz, Horwitz, Horowitz, Gurevich, Urwitz, Orowitz, Gurvich, Gerovich, Hurwicz, Hurewicz, Hourwitz, Horwicz, Horovitz, Harwitz, Harrwitz, Harowitz, Treiber, Markel, Rothstein, Tranter, Frei, Frye, Falk, Frje, Frej, Relustchin, Rilustchin, Relushchin, Rilushen, Gutcheroff, Frey, Frai".toLowerCase()
val all23AndMeFamilies = "Krainer, Stern, Kestenbaum, Dicker, Ludden, Weisberg, Corb, Bornstein, Rosenberg, Delman, Rubin, SCHIRESON KAPLAN, Kaplansky, Goodman, Diamond, Moscowitz, Wittman Denbina, Friedman, Wolfsohn 2 Kobolnick, Mintz Serot, Goldstein, Skolnick, Lubash, Aron, Brownstein, Mermelstein Hinerfeld, Pozefsky, Steiner, Goodman, Schmetterling, Innerfield, Kellerman, Gumaner Badek, Baddock, Cohen, Barnett, Schenofsky, Aschenofsky, Schenof zeper, shubin, tsop, hyman, cheifet Miller, Milner(?), Petrosky, Lotman, Solodky, Petrofsky, Harris, Weinkranz lazier, parnes, bergman, zohn, Dickson Karoly, Itzkowitz, Billman, Greenspan, Bookstaber, Bookstaver, Citera Hershstein, Blumstein, Grant, Shapiro Kosoff, London, Wiedman Goldhaber, Greenwald, Hindler, Elefant, Szmeirer, goldstein, weintraub, karp, Zerenowitz, Nagel, Rubenstein, Weissberg, Cohen, Gross, Goldhaber/Greenwald  Kirson Weinstein (father's side). Pulvers (mother's side). Reingold (father's mother). Lipschitz (mother's mother).  My grandfather, Israel Ullman, was born Israel Weinstein.  His father's good friends had the Ullman surname, and Israel posed by their only son in order to avoid conscription in the Czar's army.  He kept the Ullman surname when he moved to Buffalo, New York in the early 1900s. My grandmother on my father's side (Celia) was a Reingold and grew up in Zhaskov (a shtetl in the Ukraine).  Her father was Herschel Leib Reingold.  Katz (Zhaskov, Ukraine), Kramer, Pomerantz (Toronto), Ullman BILLER, ROBINSON, Cohen Lieberman, Margulies, Slusky, Ellovich Krok, Romm, Shapiro, Kramer, Gan, Nachman Pollock, Heidelberger, Heidelberg, Schorsch, Michael, Cole Fradin, Fraden, Freidin, Pianka, Cohen, Pankin, Pinkin, Rabinowitz, Hendler, Semp, Cheit, Movsha, Carter Miller, Forem, Miller Rosner Gruenholz, Greenwood, Milivancik, Miller, Moscovitz, Moscowitz, Morse, Moskowitz, Kutlarsky, Wolfe, Diamant, Kuhl, Kuslansky, Kushlianskaia, Gurewitz, Freebird, Davis, Cumins, Greengoltz, Shulman, Pardo Kirschenbaum, Stark, Rehmar, Tartakovsky, Tarkoff, Cantor, Alperin Alpert, Sablowitz, Hodes, Burger, Sherman Weinerman, halem, Weinstein, Kassman, Melnitzer, Adelsburg, Silver, Silverstein, Ashley Biederman, Spivak, Epstein, Silverstein, Snider Eisen, Goodglass, Eisen-Herman Bodner, Kitzis, Hanower, Gutrajman, Yuvilevich, kitzis Ungar, Derector, Getreu Gilman, Bloomfield, Kaycoff, Sherman, Braunstein Hitrys, Olian, Sampler, Jacobs, Chitro, O'Neill Vasenkov, Vassenkov, Vasenkova, Vassenkova, Simanovski, Simanovskiy, Simanovsky, Simanovskaya, Ð’Ð°Ñ?ÐµÐ½ÐºÐ¾Ð², Ð’Ð°Ñ?ÐµÐ½ÐºÐ¾Ð²Ð°, Ð¡Ð¸Ð¼Ð°Ð½Ð¾Ð²Ñ?ÐºÐ¸Ð¹, Ð¡Ð¸Ð¼Ð°Ð½Ð¾Ð²Ñ?ÐºÐ°Ñ? Weidenfeld, Karp, Samson, Tzoar Fels. Sack, Frame Stauber, Finkelman, Finke Benjamin, Mosias, saul, halprin, Saul Trabka, Kramer Richman, Seidman, Zelitch London, Lumbersky, Feigenbaum, Engelberg, Benyamin, Rivash, Riwosch Gandelsonas, Agrest, Storm Kofman, Ostrovskaya, Ostrovsky, Lyubinskaya, Lyubinskiy, Opelbaum, Trakhtenberg Kaminsky, Derechinsky, Lipton Liverant, Parnes, Winthrop, Leverant, Parnis, sorokina, vayntraub Soll, Rosen, Jaworski Buettner, LaRue Cohen, Ross, Annie, Anne, Ross Pugmire Gordon, Matross, Arbit, Britain, Garnick talmud, lerner, sherman Gurevich, Ismailov, Saltsman, Zaltzman, Sapozhnikov, Sandler, Horowitz, trufanova Statman, Sachs, Farstendiger, Peltz, Schtatman, Strauss, Oppenheim Fisher, Brant, Mendelsohn, Kessler glaser, gayamson, freilich, pashman, Freilich Sorokin, Rakhlis, Yampolsky, Berman Weinberger, Steiner Zaklad, Leffler, Karin Kanter, Brown, Edelstein, Rennard, Kanter Block Kleinman, Geller, Greenbaum, Brodsky, Tharp Ingel, Finkle, Turkieltaub, Stein-miller, Grinberg, Shalev Rosenberg, Waldman Tkatch, L Vogel, Cohen, Sands Prashker, Ripinsky, Rachnowitz Simche, Menczer, Sure, Tornschein, Beer, Singer, Booth Fradin, Cohen, Kupferberg, Fraden, weiss, Carter holtzman, rosen, fischman, Holtzman Blatt, Cantor, Osterwise, Osterweis Grossman, Beyer, Bogdanov Goldstein, Meripol, Miripol, Kirschner, Podbur, Joyce Fischler, Newman Evans, Gulden, Kraut, Sandler, Frommer Lebensburger, Hebel, Leavitt, Leeds Brodsky  Goldin Tartarsky, Brodsky Demar, Holland, D'Angelo Rosenfeld, Solomon, Sodos, Chodos, Kostikofsky, Zaetler, Itzkovitz, Ehrlich, Karo, Zarjefsky, Lerner, Bass Farkas, Zuckerman, Freitag Fershter katsap fidel, Fershter Feinstein, Krein (Krinsky), Friedman Schechter, Rosenberg, Moses, Friedman, Bogdanov, Bogdanoff Austin, Frank, Sobel, Johansen ozar, jagoda, friedman, ruben, rubin, sigman Luff, Rittenberg, Mann Rabinowitz, Danin, Smith Ginsberg, Gray Limmer, Barasch, Troy, Glazer, Birke, Kaplan, Gers, Pearlman, Kabrin Kraus, Ramis, Harris, Ostro Grossman, Jacobs, Morton, Merenbach Ulanoff, Lieberman Belyaev, Ð‘ÐµÐ»Ñ?ÐµÐ²Ð°, ÐšÐ°Ñ€Ð¼Ð¸, Ð¬Ð¿ÑˆÑ‚ÐµÐ¹Ð½, Ð‘ÐµÐ¹Ð»Ð¸Ð½, ÐšÑ€Ñ‹Ð¼Ñ?ÐºÐ¸Ð¹, ÐšÐ°Ñ€Ð¼Ð¸Ñ?Ð»ÑŒ, Karmi, Krimskiy, Epstein, Beilin, Karmiel, Ð—Ð°Ñ?Ð»Ð°Ð²Ñ?ÐºÐ¸Ð¹, Zaslavskiy, Ð¡Ð»ÐµÑ‚Ð¸Ð½Ñ?ÐºÐ¸Ð¹, Sletinskiy, Bailyn, Bailin, Epshtein, Ð¡Ð»Ð¸Ñ‚Ð¸Ð½Ñ?ÐºÐ¸Ð¹, Slitinsky, Ð’Ð¸Ð³Ð»Ð¸Ð½, Viglin, Wiglin, Krimski, Belyaeva Wisnberg, Gartman, Hartman Michnick, Natt Liebowitz, Baracker, Feinberg Pettler, Pittler, Pitler, Stack, Stakulski, Stakuiski, Margolis, Sterling, Starling, Fuchs, Livingstone, Evans, Epstein, Feinberg delinsky, Kirschner, Delin Cohen, Schocket, Seger bershadsky, Korenstein Mittelman, Mitelman, Peisahovich, Levin Azolin, Sadowsky, Azwolinsky, Sadowsky Krasner Epstein Fishman, Hauben, Soumerai Schwartzberg, Stephens, Mozen, Wexler, Stepansky Smolsky, Freeman, Susnitsky, Smith, Small, Schmitt, Kluk Levinsky and Helfenbein, Helf, Fishman Pomper Yagoda Stepper Youngworth Soman, Pomper Blushinsky, Rest, Frumhoff, Shanin, Kirsner, Schneider, Bush Glazman, Waligura, Sloan, Rosenblatt, Bloch, Lederman Cohen. Dukoff, neiger PORT, BIRNBAUM, GEESE, Porte Cohen, Rothenberg, Shane (Shine, Schein), Buckwald, Rotenberg, Roitenberg, Conde Rosenberg on my mother's side and Schwartz on my father's side, Brown Tausz, KÃ¡polnai, RÃ³nai, Ronai Simpson (also spelled Simsohn), Goldstein, Handsman, Robbins, Rabinowitz, Holzer (originally spelled Holcer), Meyerhoff, Groszower (or possibly Gruszower) Rudin, Kebach, Eckler ADLIN, ADLEN, FRIEDMAN, HENDIN, adlen Falia Jacobovich, Channah Goschinksy, Sarah Schutz, Forrest Glickman, Schlanger, Slawsky, Alesi cornett, levy, Gordon, Serks, Kemp Schulman, Schwartz, Wexler, Sparer sammet, windt, harris, katzenalenbogen hammerman, frisch, gammerman, schwartz, schwartzman, silverman Artz, Greenberg, Lockwood Harris, Lazar, Wisansky, Davis (Davidovic), Breakstone Feller, Rothbard, Itzkowitz Winter, Zimmerman, Scherer, Zsolnai/Solney Ehrlich, Pollack, Frank, posnansky Wigutoff, Schlussel, Schlusel, Masin, Tarlowe skop, kettner, raitzis, rich, scott, Scott Rosenberg, Lew, Krolik, Shapiro Saklad, Sogolow, Zaklad Levin, Khanin, Pesin, kaplun Friedman, Wolfhaber, Fink, West, Lapides, Gevirtsman, Goldstein, Cohen, Zimmelman, Suckle, Goldstone, Sostchen Weitzman, Fischmann, Schwartz, Circus, Simon, Mann Segal, Zohar Rudovsky, Hasson, Apel, Kaplan, Guz, Leon, Brant Robinson, Cornfeldt, Reiner Gurevich, Ismailov, Saltsman, Zaltzman, Sapozhnikov, Sandler, dean Wilensky, Reisner, Baum, Lind Braunstein, Rosenberg, Peretz, Blumas, King Goldberg, Templeman, Feffer, London Pugach, Govze, Shved, grudo Sorokin, Yampolskiy, Rakhlis, Berman, Y Goldberg, Scheckowitz, Schechowitz, Miedzianogora, Binswanger, Mayer, Raff Chernicoff, Katzman Koniger, Rosenberg Greenstein, Kassel, Nathan, Pina Feldman, Binder, Garber Tolmasky, Golubuk, Gilman, Gelgor, Gollup May, Abramowitz, Maurice Hochheiser, Davidovich Hochheiser Saperstein Pritsky, Davidovich, Saperstein, Pritsky, Price-Levine Albert, Nusimovicz, Jakubovics, Kaplan, Norse, Jacobs, Shapiro, Fried, Perkal, Perkel, Nissanovich, Noss, Jacobowitz, Spielman Levin, Motel Lerner, Koral Marco, Gindler, Mora, Michel, Stomachin, Kresilovsky, Selwyn, Boogadatsky, Blacher, Saltzman, Linn, Klarfeld, Salowitz, Gaffen Bennett, Jacobs, Perry Levitt/Marks/Markowitz, levitt Becker, Schatz, Harlib, Kapsack, Gerber Grefenson, Gerber, Feldman, Benjamin, Graefenson, Barron Yagudin, Speiser, Fischer, Serebryanaya, Hoffman Lefkowitz, Stern, Michaels Altenhaus, Deutsch, Schreiber, Adkins Belyaeva, Epshtein, Zilberov, Krimskiy, Karmi, Beilin, Belyaev, Karmiel, Ð‘ÐµÐ»Ñ?ÐµÐ², Ð¬Ð¿ÑˆÑ‚ÐµÐ¹Ð½, Ð—Ð¸Ð»ÑŒÐ±ÐµÑ€Ð¾Ð², ÐšÑ€Ñ‹Ð¼Ñ?ÐºÐ¸Ð¹, ÐšÐ°Ñ€Ð¼Ð¸, Ð‘ÐµÐ¹Ð»Ð¸Ð½, Ð›ÐµÐ¹Ð±Ð¾Ð², Leibov, Ð’Ð¸Ð³Ð»Ð¸Ð½, Viglin, Wiglin, Krylenkova Gillman, Rabinowitz, Goldfarb, Plotkin, Pistone Roemer, Beck, Herman, McDonald Malovanchik, Meshulam, Weiser Feldman, Baron, Bushinsky, Meyerwitz Bricker, Magidson, Blumberg, Lippert, Potashnic, Kelley Sones, Satanovsky, Sterns, Stearnes, Stearns, Stern, O'Benar, Barnett Aberbach, Meltzer, Rutkowsky Ghersin, Seidner, Botwinick, Horhovitz, Stern, Harris Frumpkin, Uvenstein Kurtz, Selinger, Radish, Schreibman Strisik Griner Grossman Keiser White Levine Millman, Rosenbloom Shapiro, Stieber, Goldberg Karesh, Mishkoff, Weinsel, Azaroff, Kriger Eliashevitz, Ellis, Fish, Siegel, Kirschner Pliner, Margolin, Marholin, Bochman, Buchman, Bokhman, Estrin, Pevzner, Lichstein, Lichshtein, Lichtenstein, Bremo, Paikin (Pliner) Gruber, Levine, Lustig, Krisloff, Schiff, Karp Minkin, Weber, Rosenfield, Mintz, Rosenfeld, Solnick, Kaplan, Kellerman Lipcon, Lipkunsky, Taub, Klein, Marculescu Graff, Harrison, King, Kanter Sragg, Sragowitz, Medaisky, Paposik, Lifschitz, Komarow, Meade, Rushefsky, Rush, Faller Sheinfeld, Oxenhandler, Handler, Kogan, Shapira, Markman Mintz, Slodov, baskin Hurwitz, Harwood, Fox, Doctor, Teitelbaum, Wolok, Taitelbaum Cohen, S Edelstein, b Martinsky, s Hoffman, a Greenberg e mizel, cohen, Edelstein, Martinsky, s Edelstein, Seff, Adelstein Rothstein, Goldstein, Doebber Finkelstein, Steinbach, Schrager, Saltz Baginsky, Rose, Ogus, Olsen Hurvitz, Rachins Linden(baum), Barnard, Friedman, Lubell Marinoff, Surkin, Fettman, Low, Schonberg, Schoenberg on my mothers side-Norma Rappeport-Salonic, Brooklyn, NY, 1928, Annie Newman, Ipswitch, Mass, her parents, NaumKharbazatsky, Russia, and LibbyWallach, Dr. JosephA.Rappeport, New York, his parents, Hyman Rappeport, and Annie Kovarsky, on my fathers side-on the Soowal, his mothers side-I have nothing fromPhilip Salonic side, my grandfather-Zalmon Hakohen, m. Sarah, WilliamCohen, m.RoseRabinovitz, other siblings, MaxHakohen, childHakohen, child #2 Hakohen, from them, Arthur H. Soowal, m.Cynthia Rose Charen, Sarah Soowal, m. Philip Salonic, Francis Mollie Soowal, m.Albert Green, Jessie Soowal, Rudolph M. Rubel, Jeanette Ruth Soowal, m. Samuel Sharps, Morris Soowal, m. Daisey Gorenstein, Ben Soowal, m. Sarah Lee Brownstein, Jack Soowal, m. Hannah Lipschutz. From them we have, Einhorn, Haber, Salonic, Rappeport, Kolins, K2a2a, maternal, E1b1b1 paternal, Rubel Sharps, Berk, Sterling, Keller, Bush, Polsky, Gelfin, Eisenthal, Lippen, Sayre, Ruytenbeek, Armstrong, Lindenbaum, Orleck, Wucher, Siesar, Fine, Brown, Nadekow, Stolarski, Gustofson, Wolfe, Beavers, and too many first cousins to name., My thanks to Sandra Lois Soowal for this exhaustive list, my her name be blessed forever, and to my 1st cousin Robert Rappeport, for as good as we can get from a family shrouded in mystery.  On the Salonic side, to my grandfather Philip, I hope we can connect to your family soon, hashem be willing. Shalom, Mara Salonic-Pierce, a true desert  dweller., Max Wallach, Rose Alberts, Frank Rothaus, Eva Wollinsky, Harry Salonic, 1868, b Germany, married to Rosie (Benovich?), 1874, b Russia, children, Joseph, Phillip, Sophia, Leona, Rebecca, Sena, possibly Jean, married Joseph and Ester Belchic, maternal K2a2a, paternal E-M5021 Mirochnik, Friedmann, Ossedryver, Burger, FRIEDMANN Michelson, Gniazdowitz, Niad, SCHLOSSBERG Freed, Finke, Krein, Berry, Finkelman, Siegfried Slotnick, Bolton, Rosenberg, rubinstein, Pescatore Rubisa, Schidlower (unsure of spelling), Spencer Zandberg, glickman, Feldman, soll, Solomonovich, Pritikin Schumacher, Kaye, Delgado Kalman, Greenstein, Meiselman, Davis, Landauer, Doglitzak, Rubinovitz, Mellman Turchin, Vilgerman, Zeigermacher, Titievsky, Tzikanovsky, Wiselman, Feldman, Wagner (Turchin) Kharitonov, Harit, Vatman, Alperovich Gutman, Pinken, Barnett, Gold Schwimmer, Cohen, Derelowitz, Avin Goldstein, Margolis, Cohen Taitz, Averbuch, Lev, Gurwitz Abrams, Benedick, Goldsmith, Millner Cohen, Resnick, Yudolevitch (Iodolevitch), Zeitlin, Harris, Sperling, Sohn, Abramson, Edelman, Singer, Yudelevitch levine, Levine Rubin, Stone, Cohen, Sochoy, Rutovitsky Zaifman, Zajfman, Najman, Urbinder, Spokojna, Wajcman, Goldenthal Nemchenok Veisman Kopp, shapiro Goldberg, Nusbaum Gewanter, Weintraub, Pfeffer, Aharoni Berman Zagen Kagen, Sgan-Kohen, Sagenkahn Ross, Summerfield, Wall Nesis Markovich, Moshkovich, Bronshtein, Abrahamovich, Helerter, Leibovich, Khomenko Tomar, Yaffe, Hershman, Steiner Holtzman.  Horowitz, Hofmeister. Abrahams, Yellen Rosenbaum, nagel, Oryn Bihari, Hofmann, Meth, Fischer, Bernstein, Adler, Mactaz, Zivehel, Schwarzhaupt, Bing, Wertlieb Boron, nieman Terebello, Kirby, Slep, Stempel, Slipakoff, Polmer Levine, HaLevi, Heidt, Ginsberg, Arensberg Brilon, Shafir, Mirochnik, Ryaboy, Ioffe Pither, Brook, Beliz, Steiner, Greenbaum Budner, Urich, Finkelstein, Steiner Greenspan, Wolman, Erenkranz, Gladshtein, Hanani Meisel, Sokolov, Brenner, Becker, Stein, Porter Flomenman, Barmash, Rozenshteyn, Aizman, Gokhman, vinarsky Longman Schertman Greif, Ferman Dermer, Schwartzman, Farb Gritz, Markman, Segal (Rosenberg)(Gritz) Kolin, Schickler, O Solomon, Gastwirth, Zolot, Cedar Mandel, Rosen, Kraushaar, Gagnon Juster, Schneiderman, Schamis Epstein, Schonberger, Strauss Savitt, Friedman, Goldberg, Greenspon Jannes, Weiss, Beck Helfman, Nimkovski, Tukeltaub, Itzikovitch Bernstein, Kapper, Pinzur, Nakutin Vel, X Chernoffsky, Look Goldberg, Sheinkop, Shiffman, Silver, Scheinkopf, Sheinkopf, Mastrovsky, Maystrovsky, Elconen, Cole, Cohen, Eberstein, Levine, Eichenbaum, Seefor, Mastrofsky Mark, Sicherman, Bosch, Deutsch Seigal, Goldberg averbook, lance, steinberg, rosnick, castonovich, sloane, Averbook Cypress, Minnie cypress, Pregulman Siglag, Kerner, Lustgarten Kamenetsky, Blyakher, Burchteyn, Zaslavsky, Natanzon, Berdytchevsky, Tomaschpolsky, Ostrovsky Bonyhard, Weiniger, Lux, Weil, Haas, Wachsman Kazdin, Levine, Radman feldmesser, easter Kleig, Forman, Jurist, Turner, Rose Zelwer, Silver, Naymark, Shafir, Caspi, Vinokurov, Coonin, Pogolaiev, Epstein, Fryde, Hoffman, Bromberg, Rivkin Sherman, Soresman, Levy, Shapiro Feldman Wagner Reiben, Colvin Rosen, Bloomberg London, Fink, Finkelstein, Cohen, Santos-Hatchett Krivitsky, Alpert, Frank, Devenisky, Lasky, Goldberg, German, Gibbs Frank, Bernstein, DREYFUSS Kaplan, Rudolph Dessner, Sutterman, Lieberman Fuchs, Schleifer, Friedlander, Forrester Mandwelle, Montvil, Kleiman, Katz, Parsky Wachovsky, Yastremetz, iastrametz, Schneider, Gordon, Berlin, Wartel, Wachs Witebsky, Feitelson, Cohen, Phillips, alpine Sverdsharf, Metzger, Eisenbourg, Sharp Drinberg, Kanievsky, Tabachnik, Gal, Galaburda Schneider, Weiss (White), Gross Tanenbaum, Tannenbaum, Lasky, Fischer, Rothenberg, Redmont, Friend, Halpern, Oxenhandler, Schwebel, Greenberg, Rudofsky, Nevinsky/Nevins, Vidaver, Davis, Tenenbaum, Itzchakson, Isaacson, Jacobs/Jacobson, Blier, Harrison, Goldenberg Zaiger, Tinter, Aronfosky, Pivnick, Hankin, Zager Elkin, Horwitz, HORWITZ, ELKIN, ZELINGER, Altschul Adler, Wollenrich, Rosenthal Sorocki (paternal grnadfather, don't know grandmother) Jonas (maternal grandfather shortened from Jonasofsky, Michelson- maternal grandmother), Falk Hoffman, Liederman, Timberg, Teller Litoworski, Mintz Oppenheimer, Pearlstein, Koshetz, Kohl, Union, moss Horn, Kornhauser, Lefkowitz, Glancz, Schwartz Dyson, Pilling, Wolfstone, Hytowitz, Trautwein Goldstein, Bell, Meyer, Boydman, Lipkin, Rothbein, Lind, Weinstein, Turkel, Klein, Schwartz, Tieman, Rothbank, Levine, Schneider, Schlossberg Brown, Grossbein, Minkoff, Rubin, Silberberg, Sternberg, Sargent, Chod Fuks, Rogovoy, Kofman, Ravitsky Teplitzky, Kaplan Pearlman, Becker, Pecker, Krivirutchsky, Perczik, Gordon, Baile, Rosen, Fried, Gross, Shainin, Pearlman Parks silensky, kurzweil Robinson, Raichelson, Mag, Kaufmann, Reiser, Hall Goldschmidt, Rosendorf, Wurzmann, Adler, Chalfin Silverman, Cohen, Kalfus, Stoller Gutfreind, Burg, Grosz, GrÃ¼nstein, Weis, Isjak, Weinsberger hirsch, miller Grossmann, Landau, Brounstein, Weinstein, Worms, Blumenthal, Zeider, Charnolovski, Brajtsztajn, Meyer, Salomon, Weil/Weyl, Blien, Ries, Lipstein, Friedland, Halpern/Halperin, Pedis/Pedes, Cohen/Kagan, Rich/Reich/Risch, Wahler, Cahen, Rich Wiener, Steinberg, Massey, Goldberg Feig, Honig Heinemann, Englander, Block Cohen, Sudhalter, Soodalter, Sodalter, Arkin, Ripps Fried, Bernstein, Bernhard, Tally Goldman, Finkelstein, Cantey Cohen, Liebman, Aronin, Blustein, Kramer, Licker, Kitay Mistowski, Chojnowski, Chonowski lazard, breger, helft, meyer, adler, halphen, Levy-lambert Kweller, Calig Keil, Statnekov, Stat Frank, Silver, Margaretten, Lando kahm, abramsky, tupper, hirshoff, hershoff, kaminsky, kahn, stone Shatkin, Ellis, Elosky Grock Jarofsky, Gindoff, Bardack, Hindes, Kovner, Bardach, Jarsky Greenberg, Shapiro, Issacs, Fox, Goldberg Albon, Gorbaty, Levy, Korotkin, Simmons, Zabner, Lindzon, Garbe Lipstein, Raborn Berger, Chover, Elefant, Hausthor, Milllendorf, Zeltzer Sezonov Strauss, Fischer, Natkin, Nathan, Feldman, Reese, Riesenfeld, Notkin Aptekar, Figlin, Volfovich, Shriebman, Stahl Priven, Gordon, Barg, Privin, Privis, Shvindelman, Kholodniy, Konstantinovsky, Palant, Friedman, Spector, Konstantinov Samborsky, Landow Gordon, Goldenblat, Ginzburg, Guterman Margolis, Michelson, Susman, Hall Kushner, Eidelnant, Aizman, Zlotnikova Lapin Cohen, Epstein Marchand, Sadovnik, Sivin, Zivin, Tatkow Ritwe, Shurmaster, Levine Garson, Garmise, Krasne, Stine, Stein, Mortkowitz, Greenstone, Ellis, Gottlieb, Garmezy, Krasnaglova Bauman, Mueller, Heinemann, Gross, Sartorious, Loth, Wertheim Seldner Brander, Joseph, Marcus, Eisnu, Eliahu, Fagelwitz, Rosenkrantz, Rosencrantz, Davis, Weber Kaplan, Gusova, Slobodsky Taleysnik, Dashevsky Gerszt, Mazansky, Baron, Johnson, tobias Doctrovich, Doctrow Krammer, Loeser, Goldschmidt Teitelbaum, Feldstein, Beigel, Patrych Epstein, Sobol snipper, bernstein, cohn, shapira, Caplan Ducker, Duker, Ducore, Flapan, Flappan, Manask, Altman, Artman, Lasky, Dykopr, Bekerkunst, Flapen, ducker Weiss, Cohen, Potashnik, Potash Harbokovsky, John Harbokosky, Harris Blatter, Dinofer, Finchler, Rubinsoln, Mondelsein, Chanin Ikonikoff, Woscoff, Winocur shifrin, rothstien, shapiro, Shifrin Kolchinski, Singer Abraham, Hoffman, Rofsky Koves, Kohn, Weisz, Pataki, Haasz, Hartman, Jungreis, Pahmer, Hollander, Erlich Hershkowitz, Yablonka, Allen Potashnic, Zimmerman, Rosen Weitz, kornfeld neubart, Tyrk F. Clara Weiner, Miriam Schiller, great grandmother, Tedeschi Wise, Orentlicher, Stone, Orentlicker, Greenberg, Court, Orent Fine, Goldberg, Dattner Ax, Blumberg, Ax- Nartowicz Udowitz, Lebowitz, Fersiger, Glantz, Swain Sarel, Solomianski, Salzberger, Belodubrovskaya Goldman, Kaslowitz, Siegel Meller, Flicker, Ament, Schniftman, Tannenblatt, Schoenwetter, Brodsky, Kornblit, Hausner, Fakelew, Otten, Amand, Amant, Fishbein, Fischbein, Tenenblatt, Flueker, Guberman, Haberman Pogrund, Shuster, Schuster, Shiffrin Coslen, Harris, Beckerman, Viller, Weller (Viller), Koslenko Blaker, Roth, Glassman, Baldinger Shackeroff, Fink, Woolbert, Gary, Shackeroff, MD Bagdanowski, Millikovsky, Bagdan, Miller, Goldstein Weinstock, Fenichel, Insdorf, Freed Finkelshteyn, Greenblat, Berman, Stein, Homeijer Seeligman, Openhaymer, Gross, Chalkovski Kaplan, Groveman Fredman, Oxman, Joseph Brodata, Glaser, Green Kushnir, Sheynis, enter, Veksler Block, bernheim, bloch, Gugenheim, block Lawrence, Kipnis, Barr, Baransky, Vogel, Bedol Steiner, Sugar, Tishler Krauss, Krouse, Miller, Harris, Elkins, E Maschtalier, Broitman, Bekelman, Reisz, Weisz, Neuman, Gutman, Handler, Calman, Jaskolka, Milstein, Dobroniewsky, Roth, Tosen, Apelbaum, Furst Berghausen, Spiegel, Loewenstein, Levi, Moritz, Scherbel, Heimann, Wedel Soloman, Saloman, Klein, Gershkowitz, Fisher, Ravenscroft Sandler, Rosen, Smith, Taylor Melamed, Karasik, Kagansky, Zuchovitsky Horn, Horovitz, Horowitz, Slesnick Levitan, Waldman kaplan, storch, wattman, felsenfeld, kaufman, tishman, guido Levy, Lovi, Becker, Buff, Oxman, Lyshinsky, Lerman Schwan, Langenfeld, Weil, Bear, Posner Rifkin, stroh, Post, Tassoff, Rubin, L evine, Agid, Grossel, Neiderfer, Aaron Starobin, stahl Rosenberg, Roth, Roemer, Gelernter, ROSS Katsnelson Friedlanski, Friedland Gottstein, Jacobs, Soronsky, Franks, Ginsburg, Oyer Prager, Grossman, Coursman, Goldich, Tessel, Horowitz Rudman, Brener, Brenner, Lachman, Cohen Simon, Revesz, Moss, Rosenberg, Bloch, Harris, Shack, Herman Ellis, Brown. Melekov, Gorin fox, fuchs, pachter, sochaczewer, shelower, maiseles, noruch, ehrenkrantz Kaplan, Cole, Cohen, Boyar, Tauber, Berkin, Friedman Erkes, Hutskevitch, Wurman, Berg, Harris, Spring, Pleshkow, Hoffman Rockenmacher, Berger, Rokenmacher, Rokienmacher, Rockennacher Raikow, Krakowski, Portnoff father, Rosensweig    mother, Meisel, Rosensweig Ha Levi, Jaffe Ressman, Cohen, Levy, Tenenbaum, Rubenstein Aronoff, Wolf, Wolfe Rosenzweig, Ross, Apfel, Taub, Zimmerman, Drusin Hartenstein, Cahn, Tannenzaft, Lowenstein Phillips, Weil, Alberts, Vagendorf, Freeman, Sher, Cohen Astruc, Oppenheim, Oppenheimer, landau, friedberg Fisher, Rifkin, Hill, Zaltzman Willick, Savnovsky Schwartz, Fox Stern    and    Marcus, Stern Canter, Yellin Josephson, Shiffman, Laam, Stern Valfer, Kleeberg, Schmitz, Levy Starr, Starobinski, Schub, Fradkin, Barb Cohen, Crane SHERMAN SHERMAK, Sherman Rudolph, Hurwitz, Cogen, Skilowitz, Katz, Berman Gottlieb, Bellow, Cotler, Goldberg Cohen, Gelson, Rosen, Needle Wahrsinger, Friedman, Fagnoni Goldweber, Cohen, Mittenthal greenberg, samess Gundersheimer, Appel (Apple), Slaughter, Starr Parnas, Selibovsky, Selib, Wilheim Teich, COHEN, Simon, Weiner, Samtigan, Berkowitz Krupnikoff, Schneider, Freeman, Kanzrowitz, Krupnik, Rosenblum rosenkranz, klauber Winograd, Horvitz, Katz, Alexander, Cohen Sado, Belkin, Greenblat Pochapovsky, Spears, Dalkin, Blaiss, Rifka, Herch, Harris Fremed, Landsman, Katz, Burrill Kobrin, Weisbart, loshevin, SIMONS Levine, Potruch, Potrop, Klorman, Klarman, Buslovitch, Gottlieb, Krupnik, Weil, Naiditch, Naidich, Gers, Wisenfeld, Katzenelson, Berman, Shapshai, Shapshay, Gorelick, Horelick, Brody, Brodie Schattil, sieradzki, rosen, Midgen Cantor, Greenwald, Canter, Copelan Goldstein, Hoffmeyer Peck, Polius, Palla, Lewis, Einhorn, Theisz, Melnick, Zucker, Zeiben, Horn Yanow, Goldberg, Schwartz, Frazier Zarit, Zaritsky, Siskin, Weiss, Brough Perlin  and Boder and Glazier and Ravitsky, Neidle Davis, Helfman, Binkovitch, Pozen Salzman, Gold, Silverman, Graubart inker, zlatareva, blyakher, vaynshteyn, Inker Boernstejn, Bernstein, Gaftik, Gaftick, Dube, Sacks, Zaks Siderbaum, Levy, Freeman, Tepper Hess, Bauer, Oppenheim which was changed to Oppens. Cohen, Friedrichs, Wolfers, Kaufmann, Heine, kaufmann, Rafaeli, Hess Hammerling Schacknow, Koss, Berger, Rothschild, Cochran Bedzofsky, Zuckerkendle, Sylberbusch, Miller, Beede srosenblum, schein, Heller, pearl, Maccabee Lurie, Markovitch, Rivkind, Tarler, Barkan Linetsky, Levner, Akselrod, Mezheritsky Gesser, Vasilkovsky, Niselevich, Feyga Vasilkovsky, Feldman Bloomenfeld, Knopf Tennenbaum, Somers, Baum Lipton, Ehrmann Rosen, Godfried, Siedenstadt, Rumizen Spiegel, Melman, Josephi, Raskin Kornfeld, Katz, Afram, Afromowitz, Starr, Cornfield Kornhauser, Wolfson, Zucker, Birlofsky Becker, Galinsky, Herschlag Bor, Berens, Berenstain, Berenstein, Stein, Loitz Laskov, Fothergill, Eck, Morrell, Webb, Bloom, Kirchherr, Ellis, Lewis, Davidson, Kreuger, Klausner, Pack, Rose, Feingold, Der Brucke, Cutler, Mishlove, Olins. Hamond, Babbin, Glickman, Berger, Kaplan, Moshel, Kass, Norwich, Yanofsky, Brooks, Halmowitz, Colton, Gershonowitz, Baron, Himmelstein, Rosin, Adelman, Lichetenstein, Sherman, Beck, Roth, Karp, Tennenbaum, Plummer, Aaron, Bartner, Sokol, Mareyne, Graff, Prince, Hershfield, Sachs, Rabetz, Frank, Baronoff, stein berger, katzenberg, fishmann Kopelowitz, Stiefel, Lind, Kopelove Glassberg, Poserow, Klugerman, Lehman, Powers Schwartz, Wohlwill Henkus, Marks, McLaughlin Kaiser, Chasis, Bress, Radin Benedict, Birnbaum, Juchvid, Gratz, Birns Blumenson, Beren, Halpern, Neyfelt, Wagesnberg, Sandzer, Gutman, Wyszinski, Nusman, Dobiecka, Katzov, Wizenberg, Szterdyner, Antkes, Rotsztejn, Burstzejn, Makowski, Barasz, Nemoy, Friedman, Bartak, Rosenberg, Schliak, Pecker, Rotszyld, Chencinski, Gancarski, Izrael, Glicksman, Dymand, Lerner, Taglicht, Landau, Opatowski, Irlicht, Boms, Orner, Hendeles, Bloom Holtzman cohen, Heller Weiss, Stern Gutter, Loewi, Loewy, Florenko, Hershenzon, Feinschriber, Herschenson, Medvedev, Pitkovsky, Feinshriber, Yakir Rudovsky, Abraham, Kula, A Adlen, Strauss, Jaffa, Hendin, Gandin, Rosenwald Cohn, Applestein, Tabb, Becker, Simowitz, Zashinsky, Schumer, Makofsky, Berger, Siegal, Wand, Baitch Eventove, Messer, Alber, Kuttaschoff, Cutler Eisen, Katzoff, Celler, Hellman Levine, Dockswell Cherches, Urin, Kraydman Claytor, Shannon, Black, Turner Rashkow, Auerbach, Averbach, Byman, Goodman, Keane, Kenedy Miller, Shapiro, Ferber, Springer Sandler, Abramovitz, Kleyman, Chejanovieski, Gurvitz, Silverstein Sandler Shapiro, Stern, Burgheim, Silberman Cohen, Brown Silverman, Sargent, Helfand, Kershenbaum feldman, Feldman Brin, Medovy, Zabar, Gimpelson Armuth, Weiss, Wolkoff Goldenberg, Lunin, Levinson Horowitz, schwimmer, Teitelbaum, Landau, Horovitz, Katz Mesel, Arutt, Litzky, Abramson, Green, Lansy, Gershon, Cohen, Rosenfeld Bronsther, Gross, Bronster, Braunstein, Zaslovsky, Steingardt, Rutstein, Rothstein, Poretsky, Poret, Paretzkyn, Schocklander, Shpitzgluz, Boyarin, Dubrow, Epstein Marienstrauss, Wolfson, Goldenberg, Propper, Lang, Nussbaum, Rudman/Rodman, Strauss, Nissenbaum, Brenner, Potzuk?, Marigold Starikov, Gurevich, Charny, Charnyi, Dayan Kaufmann, Lissner, Leyser, Lob, Shaumberger, Schomberg, Beadle Redner, Petlik, Pitliuk, Polakiewicz, Pitliukas, Petlik Fischer Kushner, Kustamalutsky Zeitlin, Wolfson, Zuker, Charny, Schwartz, Charny-Schwartz, Reizis Gurevitz, marcus, Jaffe, sidransky schechter, bogdonoff, orgel Gotlin, Gotlinski, Gotlinsky, Liebler, Gladstone, ripley Kessler, Ulberg, Freimour, Monter, Freiermauer kleynman, kleiman, kleynerman, mareynis, Grinberg Wolman, Feigenbaum, Sztainberg, Grinberg, Green Fidel, Palmieri, Capezio, Borek Blaugrund, Goldman, Marcus, Horwitz, Glattstein, Schwartz, Fischler, Diamond, Ungar, Gladstone Bryski, Munitz, Brzyski, Pshemish, Eckhaus Perlow, Braunstein, PERLOW Childs, Bydlowski, Perelmiter, Perlmutter, Chajet, Berg, Staszewski, Wajnstok, Tenenbaum, Lipa, Blumenfeld, Frajman, Solewicz, Chait, Cymet Sherry, Shereshfsky, Shereshevsky, Chomsky, Palevsky, Krantz, Scher, Kreminetz, Shomsky, Silverman, Pollyer, Balazky, Bell, Gilman Singer, Rosenthal, Delvin, Yaffe Baroff, Grossman, Magrill, Fishman Backman, F, Fanger, Dworet, Faingert, Tobin Boles, Boleslawsky, Utal, Grosby, Wallenstein, Levy Schiner, Eisenberg, Ritter, Lapidus, Chernovsky, Ahler, Bublacki, Sheine, Kaplan, Friedman, Berezer, Gillmann Pisen, Wexler, Shapiro Roth, Tauber, Birnbaum, Brand, Reiss, Meyer, Murray, Mendelson Kurgatnikow, Strauss, Blumenthal, Kogen, Cohen, Saban, Shaban, Seiban, Sabin, Cheren, Charren, Tzern, Cherrin, Goldschmidt, Eisenthal, KRUG Dal, Goldstein, Moskowitz, Rabinowitz, Morschowitz, Dall Blatt, Hochman, Sigelman, Krauss kaplan, markel, Bigunetz, Vigunetz, Teplitsky Braus, Loeb Friedberg, Shepsenwohl, Borg Ginsberg, Werksman, Stern, Katz Stoller, Patur, Weisler, Berkowitz Pivovitz, Chachol, Horwitz, Zacharovitz, Millunchik, Mullinchik, Milner, Miller, Kobrinsky, Koby, Mattewetski, Matt, Smolin, Percus, Goldberg, Sayre, Glick, Rothman, Rottman, Rottmann, Lefkowitz, Weinstein, Hoffman, Ornstein, Wasserbach, Chunovitz, Chunovic, Chunovich, Zalmanovitch, Wechselberg, Vekselberg, Prinz, Tillemann, RP Sigall, Cohen, Usatin, Frenkel, Shandloff, Kohn, Halpern, Schiffman, Entin, Sandalov, Halperin, Zhmudsky, Usatine, Tunik, Gittelson, Lieblich, Stein, Felberbaum, Tunick Gross, Bettinger Lipschitz, Gerber, Brauer, Joseph, Lister, Mann, Shur, Velenski, Wolff Khodos, Boriskovskiy Blank, Courshon, Brail, Brailowsky Zuckerman, Meltzer, Metzgroff Cooper, Petrov, Katz Greene, Greenebaum Derector, Derectov, Tocker, Ungar rose, Tennin Prince, Werfel, Dunn backman, fanger, dworet, sack, Backman Zlotnik, Lifshitz, Yekelchik, Tanchilevich, Ekelchik Kalmanovich, Rabkin J. Rosenberg, Bella Siderman, Rochel Frank, Yisroel Fogel, Ephraim Gold, Sarah Rivka (Regina) Stager, Meyer, Neiman Stinsky, Dobrushkin, sorkin, Sorkin Kirsh, Galinsky, Kirshner Shraberg, Schreiberg, Samole, Simolovich, Cohen Ruslander, Cristall, Laguna, Bruckheimer Bokor, Fier, Fier-Noggle Shlesman, Millmeister, Mealus Haber, Stahl, Kurtz, Weissberg Goldberg, Shetisky, Fine, Fivelovitz, Carlyn Dinn, Sadugor, Liff, Greenberg, rapaport, grunberg, jocoby, lowe, Robins Birenbaum, Weisman Schwager, Marcus, Heft Charin, Willner Kritzler, Rifkin, Roth, Burk Van der valde, Weiss, Greizer, Landsberg Stone, Woolf, Staviska, Todd Freedman, Feinberg, Blash Shapiro, Girard Lederer, Thorman, Rosenfeld, Unger, Oppenheimer Albaum, Feinstein, Steinman, Pinchik Frankel, Baron, Nagler, Charlomov, Harmon Bloom, Lovinger, Burstiner Sweet, Shweid, Miller, Carlin, Jacobs, Albert, Rosenberg, Liss, Miles Maitin, Shusterman Lerner, Adler, Bernstein, Heistein Engle, Wolfson, Katz, Tessler, Stone, Sitrick, Steinhart, Samuel Gordon, Wasserman, Goldberg, Goldstein, Saunders, Myers, Brown Janofsky, Reizer, Wigotsky, Norris Dorf, Asher milner, milner-melnikov, Leybman, Lebman Williams, Cohen, Kagan, Fuchman, Albaum Rubenfield, Birken Rabinowitz, Bresgi, Zilibowitz, Eiran Gaffen, Garfinkel, Zisook Lifshutz, Ring Epstein, Scharf, Mach, Korr Korn, Kohn, Hollander, Heilbraun, Mermelstein Gladstein, Staver, Slifkin, Slivkin, Sonstein, Slifkin-McClure Lipkin, Simovich, Serken, Terniack, Lipton Kaplan, Kapalhovitch, Cramer Cohen, Kessler, Cortez Maternal, Meyerhoff, Goodman, Paternal, Efron, Efron-Flier Urowsky, Urovsky, Ginsburg, Ginsberg, Shwartzman, Landis, Landes, Landers, Hoffman, Rothman, Schulman, Gainsberg, Rowe Rosensweig, Rosenzweig, Ravetz, Ravitzsky, Lubell, Lubellski, Kasofsky, Shumacher, Baronofsky".toLowerCase().split(" ", ",", "(", ")")
val mapOfSharedSoundexToSurnames:MutableMap<String, String> = mutableMapOf("Soundex" to "Surname")
fun main() {
//    println("Repeateds = ${findDifferences(familyList2,familyList1)}")
    val listOfMyFamiliesBeforeGEDCOMS = myFamilies.split(" ", ",")
    val listOfMyFamiliesAfterGEDCOMS = listOfMyFamiliesBeforeGEDCOMS.toMutableList()
    val ancestryFile = File("C:\\Users\\Shmuel\\IdeaProjects\\Sandbox4\\src\\Ancestry Sternbach-Blood Tree (1).ged").readText().toLowerCase()
    "(?<=/)\\w+(?=/)".toRegex().findAll(ancestryFile).forEach {
        if (it.value !in myFamilies)
            listOfMyFamiliesAfterGEDCOMS += it.value
    }
    val geniFile = File("C:\\Users\\Shmuel\\IdeaProjects\\Sandbox4\\src\\Geni export-BloodTree.ged").readText().toLowerCase()
    "(?<=/)\\w+(?=/)".toRegex().findAll(geniFile).forEach {
        if (it.value !in myFamilies)
            listOfMyFamiliesAfterGEDCOMS += it.value
    }
val daitchencoder = DaitchMokotoffSoundex()

    for (familyName in listOfMyFamiliesAfterGEDCOMS) {
        for (`23andMeFamilyName` in all23AndMeFamilies) {
            for(soundex in daitchencoder.soundex(`23andMeFamilyName`).split("|")){
                for(soundex1 in daitchencoder.soundex(familyName).split("|")){
                    if(soundex==soundex1) {
                        sharedSurnames.add(`23andMeFamilyName`)
                        mapOfSharedSoundexToSurnames[soundex]+=",$`23andMeFamilyName`,$familyName"
                    }
                }
            }
//            if (`23andMeFamilyName` == familyName && `23andMeFamilyName` !in getSharedSurnames) getSharedSurnames.add(`23andMeFamilyName`)//TODO Insert daitch mokotoff calculation here
        }
    }
    val sharedSurnamesSorted = sharedSurnames.sorted().reversed().toMutableList()
    sharedSurnamesSorted.removeIf {
        it == "" || it == " " || it == "," || it == ", "
    }
    for (name in sharedSurnamesSorted.distinct()) {
        if (name in listOfMyFamiliesBeforeGEDCOMS || name == " " || name == "," || name == "") continue
        else sharedInLawNames += name
    }
    sharedInLawNames -= sharedInLawNames[0]
    val sharedSurnamesMappedToFrequency = HashMap<String, Int?>()
    sharedSurnames.forEach {
        if (sharedSurnamesMappedToFrequency.containsKey(it)) {
            val count = sharedSurnamesMappedToFrequency[it]!!
            sharedSurnamesMappedToFrequency[it] = count + 1
        } else {
            sharedSurnamesMappedToFrequency[it] = 1
        }
    }



//    val commonSoundexMappedToFrequencySortedByValue = commonSoundexMappedToFrequency.toList().sortedBy{it.second}.reversed().toMap()
    val sharedSurnamesMappedToFrequencySortedByValue = sharedSurnamesMappedToFrequency.toList().sortedBy{it.second}.dropLast(1).reversed().toMap()
//    println("SharedSurnamesInProccess: ${it1.first.prependIndent("\n")}=${it1.second}")
    println("Set of shared surnames:\n${sharedSurnamesSorted.toSet()}")
    println()
    println("List of shared surnames:\n$sharedSurnamesSorted")
    println()
//    println("Frequency of shared surnames:\n${sharedSurnamesMappedToFrequency}")
    println("Set of shared in-law surnames:\n$sharedInLawNames")
    println()
    println("Frequency of shared surnames:")

    sharedSurnamesMappedToFrequencySortedByValue.toString().split(", ").run {
        forEachIndexed { index, it ->
            when (index) {
                0              -> println(it.removePrefix("{"))
                this.lastIndex -> println(it.removeSuffix("}"))
                else           -> println(it)
            }
        }
    }
    println("Shared soundexes sorted by number of families(commas): ${mapOfSharedSoundexToSurnames.toList().sortedByDescending{(_,value) ->value.count{it==','}}.toMap()/*will this work????*/}")
}


fun findDifferences(before: List<String>, after: List<String>): MutableList<String> {
    val differences = mutableListOf("")
    for (value in after) {
        var found = false
        for (s in before) {
            if (value == s) {
                found = true
                break
            }
        }
        if (!found) differences.add(value)
    }
    return differences
}
