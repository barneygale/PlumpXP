# PlumpXP

A fairly simple bukkit plugin to achieve a few odds and ends:

1. Multiply XP drops from all mobs (=> reduce XP farming)
2. Multiply XP drops from blazes (=> make blaze farms less OP)
3. Change player XP drops to be a fraction of total XP (=> rather than being limited/derpy)

##Config

* plump-multiplier - multiplies all mob XP drops
* blaze-multiplier - multiplies blaze XP drops. NB: also multiplied by first field; use 0.5 to bring in line with other hostile mobs
* player-override - whether or not to override vanilla player xp drop behaviour
* player-multiplier - multiplier for player XP drops. A value of 1.0 will transfer all XP on player death

##Commands

Players with the plumpxp.reload permission can use /reloadplumpxp to reload config.
