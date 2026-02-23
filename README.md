# 🎮 Šutr a Kámen!
Jednoduchá konzolová videohra vyvinuta v Javě jako vánoční školní projekt.

## 📑 Příběh
V daleké budoucnosti mezihvězdná korporace Deep Rock Galactic (projekt je lechce
inspirován stejnojmennou videohrou) nalezne planetu plnou drahých minerálů a
velice nebezpečných pavouků->glyphidi, tato planeta si zasloužila název Hoxxes IV.
Tahle korporace začne sesílat raketou trpaslíky na tuto planetu, aby pro ně přes
hrozbu vetřelců těžili minerály v hlubokých jeskyních. Vy jako hlavní postava trpaslíka
pracujete pro tuto společnost, a vydáváte se na adventúru do vnitřka této planety,
zneškodnit cizáky a získat cenné minerály.

## 🎯 Cíl
Hlavním úkolem hráče je natěžit dostatečný počet suroviny morkite, naleznutelná v
různých jeskyních, a na konci úspešně evakuovat raketou ve finální úrovni: evakuační
plošině.

## 🏆 Postup k vítězství
Při hraní hráč zabijí gigantické ,,pavouky’’, zvaní glyphidy, pomocí zbraní, může také
těžit zlato, se kterým si může zakoupit lepší zbraně s obchod-o-botem, který se
nachází v nekterých místnostech. Další těžitelná surovina je nitra, kterou hráč používa
k zavolání menší rakety s municí, aby mohl používat zbraně. Hráč vyhrává ve
chvíli, kdy vytěží dostatek minerálu morkite, zavolá si evakuaci v poslední úrovni a
samozřejmě, pokuď přežije.

## 🏡 Místnosti
1. Space Rig - 
Vesmírná stanice, orbitující planetu, ve které se hráč poprvé náchází.
Může si zde popovídat s charaktery pro tipy.
A přejde odsaď do reálné mise, avšak se již po opuštění nebude moct vrátit.
2. Slané hlubiny - 
První biom, do kterého hráč přestoupí.
Veliké solné pláně tvořené primárně ze soli.
Obsahuje nepatrné množství zlata a morkitu, zato však hodně nitry.
Hráč se zde poprvé setkává s glyphidy.
3. Radioaktivní zóna - 
Jeskyně, jejíž pevné stěny jsou od dlouhodobého působení radiace
zdeformovány do běla.
Hráč zde najde obchod-o-bota, u něj může koupit výbavu za zlato.
Obsahuje velice malé množství minerálů, ale mnoho zlata, které je chráněno
poměrně velkým počtem glyphidů.
Rozdvojuje se do 2 biomů: ledovcové straty a do krystalových jeskyň.
4. Ledovcová strata - 
Celá jeskyně je složena z ledu, z důvodu že se nachází na permafrostových
tektonických deskách.
Nachází se zde poměrně hodně morkitu a hordy glyphidů, hráč by
neměl bojovat se všema.
5. Krystalové jeskyně - 
Biom formovaný zcela z bezcenných krystalů, silikátu.
Vyskytuje se zde nemalé množství všech minerálů a skoro žádní glyphidi.
6. Pískovcové zákoutí - 
Gigantická, otevřená jeskyně tvořená z pevného pískovce.
Obsahuje velké množství zlata.
7. Magmatické jádro - 
Rozžhavená jeskyně kvůli blízkosti k jádru planety.
Nitra je zde abundantní, společne s morkitem. Pomerně hlídaná oblast.
8. Evakuační platforma - 
Spojuje pískovcové zákoutí a krystalové jeskyně.
Finální část hráčova dobrodružství, zde pokuď zvládl vytěžit dostatek morkitu,
tak může úspešne evakuovat zpátky do stanice a vyhraje tak hru. Pokuď však
nemá dostatek, tak se bude muset vrátit a vytěžit chybějící surovinu.

## 🧑‍⚕️ Důležité postavy
1. Hlavní postava - 
Trpaslík najatý gigakorporátem Deep Rock Galactic, pracuje jako najatý dolník,
který má za úkol získat morkit a zneškodnit glyphidy.
2. Nepřátelé - 
Bezmozkovití gigantičtí pavouci chránící své území, nelíbí se jim prezence trpaslíka
níčící jejích domovy.
3. Obchod-o-bot - 
Robot, u kterého si hráč může za zlato nakoupit výbavu: pistoli, útočnou pušku a
sniperku.
4. Skvadra na stanici -
Skupina ostatních najatých trpaslíků na začátku hry, kterých se hráč může zeptat
pro různé tipy k tomu, co ho čeká.

## ⚒️ Předměty a inventář
Hráč za svůj playthrough může získat hlavně dva typy předmětů, a to minerály a
výbavu.

Minerály nitra a zlato jsou v omezené kapacitě v inventáři, aby hráč nemohl rychle za
sebou volat zásoby a aby nemohl najednou vykoupit obchod-o-bota.

### 💠 Minerály
Suroviny, které jsou všechny získatelné vytěžením krumpáčem v jeskyních, jsou to:
 - Morkite: hlavní surovina, tu hráč musí těžitv dostatečném počtu, aby uspěl v misi
 - Nitra: červený materiál, tím si hráč může přivolat k sobě menší zásobovací raketu, kterou může jednorázově použít pro doplnění životů a munice
 - Zlato: měna, dá se za ní zakoupit zbraně u obchod-o-bota

### 🎒 Výbava
Základní výbava hráče, zahrnuje krumpáč, tím těží suroviny nebo mlátí
glyphidy zblízka, další výbava jsou střelné zbraně, konzumují ale munici kterou si
hráč může doplnit jen zavoláním zásobovací rakety za minerál nitra, zbraně jsou:
- pistole: malé poškození, malý dosah, vzato hodně dostupná munice
- útočná puška: střední poškození, střední dosah, menší spotřeba munice
- sniperka: velké poškození, velký dosah, ale největší spotřeba munice

## 💻 Herní mechaniky
### Herní prostředí
Nejdůležítější herní mechanika je interaktivní 2D prostředí tvořeno 2D arrayem, které
se printuje do konzole. Je tvořena z políček, ve kterých můžou být všechny elementy,
které se vyskytují v místnosti, například hráč může vidět sám sebe jak se pohybuje
dle jeho příkazů (nahorů, dolů, vlevo, vpravo), vidí nepřátelé, suroviny, zdi a další.
Pohyb nepřátel funguje na bázi tahů, kdy vždy se pokračuje když hráč zaútočí, začne se 
pohybovat atd.

### ,,AI'' pohyby nepřátelů
Nepřátělé mají vlastní jednoduché AI, kdy pokaždé když vidí hráče (není mezi hráčem
a pavoukem zeď) tak začnou bežet za hráčem a zaútočí zblízka.

### Těžení
Na mapě se vyskytují suroviny, hráč by je může těžit, a to může když je dostatečně
blízko

### Útok
Hráčovy zbraně mají svůj vlastní range a když přímo vidí nepřítele a je dostatečně
blízko pro zvolenou zbraň, tak může zaútočit.

### Interakce s NPC
S přatelskými charaktery může hráč interagovat pozitivně, s obchod botem pro
zakoupení zbraní a se skvadrou trpaslíků na vesmírné stanici pro všelijaké rady.
S pavouky interagovat může pouze přes násilí.

## ⌨️ Seznam příkazů
attack x y               ==> Zaútočíš na nepřítele na x y

collect x y              ==> Sesbíráš resupply na x y

door x y                 ==> Vstoupíš do dveří na x y a přesuneš se do jiné místnosti

end                      ==> Ukončíš hru

escape x y               ==> Vstoupíš do únikové rakety a při dostatečném množstvím morkitu zvítězíš

explore x y              ==> Vypíše informace o předmětu na x y

help                     ==> Vypíše tuto nápovědu s komandama

inventory                ==> Vypíše všechno, co máš v inventáři

mine x y                 ==> Vytěžíš rudu na x y, musíš být blízko

w | a | s | d            ==> Pohyb po mapě, až 3x krát opakovatelné v jednom příkazu

resupply x y             ==> Zavoláš si zásobovací raketu na x y, stojí 80 nitry

room                     ==> Vypíše informaci o místnosti, ve které jsi

setweapon nazev-zbrane   ==> Nastaví tvoji primární zbraň, aby si mohl útočit

talk x y                 ==> Promluvíš s postavou na x y
