rootProject.name = "nuvotifier"

include("nuvotifier-api")
project(":nuvotifier-api").projectDir = file("api")


include("nuvotifier-common")
project(":nuvotifier-common").projectDir = file("common")

include("nuvotifier-bukkit")
project(":nuvotifier-bukkit").projectDir = file("bukkit")
//include("nuvotifier-bungeecord")
//project(":nuvotifier-bungeecord").projectDir = file("bungeecord")
//include("nuvotifier-sponge")
//project(":nuvotifier-sponge").projectDir = file("sponge")
//include("nuvotifier-fabric")
//project(":nuvotifier-fabric").projectDir = file("fabric")
///include("nuvotifier-velocity")
//(":nuvotifier-velocity").projectDir = file("velocity")

include("nuvotifier-universal")
project(":nuvotifier-universal").projectDir = file("universal")