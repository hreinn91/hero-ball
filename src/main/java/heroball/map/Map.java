package heroball.map;


import heroball.character.Character;
import heroball.character.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * A map should keep track of the size of a map and the position of all characters within the map.
 */
@AllArgsConstructor
public class Map {

    @Getter
    private final int width;
    @Getter
    private final int height;
    @Getter
    private final Player player1;
    @Getter
    private final List<Character> characters;
}
