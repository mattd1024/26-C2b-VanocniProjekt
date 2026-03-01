# 🎮 Šutr a Kámen!
Jednoduchá konzolová videohra vyvinuta v Javě jako vánoční školní projekt.

Hra se odehrává v budoucnosti na daleké planetě a vy hrajete za trpaslíka,
jehož úkolem je v jeskyních natěžit dostatečný počet minerálu morkite
a na konci uniknout.

## 🌟 Hlavní funkce
- Pohyb po 2D mřížce, kde je možno vidět celou jednu místnost
- Nebezpeční nepřátelé s jednoduchým pohybem, postupně se blíží ke hráčí a v blízkosti zaútočí
- Hráč může útočit se zbraněmi, každá má svojí vzdálenost a spotřebu munice
- Těžení minerálu:
  - zlato - kupování zbraní
  - nitra - zásobování a léčení, 
  - morkite - nutný pro splnění hlavního objektivu
- Kupování různých zbraní za zlato
- Přivolání zásobovací rakety za minerál nitra
- Komunikování s přátelskými NPC

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

## 💻 Jak hru spustit
Hru lze spustit několika způsoby:
- Klonujte repozitář do svého oblíbeného editoru podporující javu a spusťtě třídu Main.java v něm
- Stáhněte si soubor SutrKamen z projektu a v něm přes konzoli spustťe .jar soubor
komandem `java -jar SutrKamen.jar`

   > [!IMPORTANT]
   > Pro tento krok je nutné mít funkční javu v konzoli\
   > V projektu je využita Java 21

## 📦 Použité balíky
[GSON](https://github.com/google/gson) pro načítaní úložného souboru typu .json

[JUnit](https://github.com/junit-team/junit-framework/) pro testy

## ❤️ Inspirace
Projekt byl silně inspirován videohrou
[Deep Rock Galactic](https://store.steampowered.com/app/548430/Deep_Rock_Galactic/)

