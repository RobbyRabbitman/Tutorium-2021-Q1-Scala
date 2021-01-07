# 2
## a), b), c)
+ Eingabe
    + Nachname (bestehend aus Großbuchstaben (Also entweder Input modifizieren oder validieren), Bindestrichen, Leerzeichen)
    + Vorname (wie Nachname)
    + Geburtsdatum (bestehend aus Jahr, Monat und Tag; alternativ wäre hier auch eine kombinierte Angabe denkbar, dann bräuchte es aber auch noch eine definierte Möglichkeit zur Kennzeichnung von fehlenden Werten)
+ Ausgabe
    + Definition von fester Länge und den einzelnen Abschnitten (interessant sind hier ggf 11. und 12. Stelle da dort nicht alle Buchstaben und Ziffern auftreten. Das ergibt sich dann auch aus den Berechnungen der einzelnen Abschnitte)
+ Berechnung 
    + Der Teil fürs Geburtsjahr kann durch Jahr mod 100 ermittelt werden, es muss aber auch definiert werden wie ein unbekanntes Jahr angegeben werden muss. Hier könnte man noch drüber nachdenken wie mit negativen Jahreszahlen umzugehen wäre, oder dass man die vielleicht auch explizit als erlaubte Eingaben ausschließen würde
    Monat - da muss das Mapping genau beschrieben werden, z.B. eine Tabelle, oder vielleicht auch sowas wie der n.-te Buchstabe im Deutschen Alphabet; Auch hier muss wieder das Thema undefiniert behandelt werden. Der Wertebereich ist hier natürlich auch stark beschränkt, das wäre auch etwas was man besser gleich mit bei der Beschreibung der erlaubten Eingaben ergänzt
    Tag - analog zu Jahr und Monat
    Name und Vorname sind ähnlich, aber nicht identisch: Namenszusätze (welche sind das überhaupt alle - das ist ggf. auch etwas für die Frageliste) vor dem Nachnamen müssen entfernt werden.
    1. Es müssen alle Ersetzungsfunktionen aufgeführt werden in einer eindeutig definierten Reihenfolge angegeben werden. Wie umgehen mit Speziellen Nicht-Deutschen Buchstaben? (für die Fragen: was mit solchen machen für die es keine "offensichtliche" Umsetzung gibt?
    2. Bildungsregel für die 4 Buchstaben aus dem bereits ersetzen Namen
+ Berechnung der Prüfziffer
    + Ein beliebter Fehler ist die Berechnung so wie im direkt bei Wikipedia verlinkten Prüfziffer-Artikel. Da muss natürlich das richtige Verfahren recherchiert und die Berechnung beschrieben werden. Und was genau wird als Eingabe für die Prüfziffernberechnung verwendet?
## d)
Hier bietet es sich an vollständige Beispiele aus mehren seriösen Quellen (das wäre auch noch mal ein Punkt über den sie sprechen sollten. Bevorzugt sollte man auf offiziellen Spezifikationen zurückgreifen, nur Wikipedia ist gefährlich!) zu verwenden, und ggf. auch noch eigene zu konstruieren (wobei die dann wahrscheinlich eher einfach ausfallen werden). Für Fehlerfälle gibt es beim Datum viel Potenzial: Monat <1 oder >21, Tag <1 oder >31 und Monatskombinationen mit weniger als 31 Tagen testen. 29. Februar mit und ohne Schaltjahr testen incl. der "besonderen" Schaltjhresregeln für glatte 100er und 400er Jahre
## e)
Die Berechnungen kann man gut für die Einzelteile separieren. Für die Namensberechnung z.B. eine Aufteilung wie 1. Umwandlung in Großbuchstaben, 2. Entfernen der Namenszusätze (nur für Nachnamen, wäre dann aber nur mit Großbuchstaben potenziell schon einfacher), 3. Berechnung der 4 Zeichen (das lässt sich auch noch mal wieder herunterbrechen...). Das testen wird dadurch tendenziell einfacher, weil man z.B. nicht mehr für jeden Testfall auch eine (hoffentliche korrekte) Prüfziffernberechnung vornehmen muss. Test der Prüfzifferenberechnung kann auch mit einer Auftrennung der bisherigen Testbeisiele erfolgen