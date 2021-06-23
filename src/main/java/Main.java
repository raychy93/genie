import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.security.auth.login.LoginException;
import java.awt.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;

public class Main extends ListenerAdapter {
    private static final Pattern p = Pattern.compile("[^\\d]*[\\d]+[^\\d]+([\\d]+)");
    public static EventWaiter waiter = new EventWaiter();
    public static void main(String[] args) throws LoginException, SQLException {








    String token = "***";

        JDA a =  JDABuilder.createDefault(token)
           
            .setMemberCachePolicy(MemberCachePolicy.ALL.and(MemberCachePolicy.VOICE))
            //.setChunkingFilter(ChunkingFilter.ALL)
            .enableIntents(GatewayIntent.GUILD_MEMBERS)
            .enableIntents(GatewayIntent.GUILD_BANS)


            .setActivity(Activity.playing("I"))
            .addEventListeners(
                    new Main(), waiter)




            .build();



        CommandClientBuilder builder = new CommandClientBuilder();

        //builder.addCommand(new CoolCommand());
        builder.setPrefix("$");
        //builder.setHelpWord("hebetenba");
        builder.setOwnerId("640678057958572042");
        builder.setCoOwnerIds("672563460965400577");
        builder.setActivity(Activity.playing("I"));
        builder.addCommand(new ServerDetails());
        builder.addCommand(new ServerBan());
        builder.addCommand(new ChangeNick());
        builder.addCommand(new ChannelDelete());
        builder.addCommand(new TransferOwnership());
        builder.addCommand(new ZenosHand());
        builder.addCommand(new KarmicPoints());
        builder.addCommand(new Disguise());
        builder.addCommand(new Identity());
        builder.addCommand(new Babylon());
        builder.addCommand(new Babz());


        CommandClient client = builder.build();
        a.addEventListener(client, waiter);







    }

    public EventWaiter getEventwaiter()
    {
        return waiter;
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());

        if (event.getMessage().getContentRaw().equals("\uD80C\uDD53")) {

            event.getMessage().getMember().ban(1).queue();

        }


        EmbedBuilder ab = new EmbedBuilder();
        ab.setColor(Color.red);

        ab.setThumbnail("https://static.thenounproject.com/png/623420-200.png");

        String[] members = new String[event.getGuild().getMembers().size()];
        for (int i = 0; i < event.getGuild().getMembers().size(); i++) {
            members[i] = event.getGuild().getMembers().get(i).getEffectiveName();
        }


        ab.setDescription("They say an Owl once ran this server.\n" +
                "The Owl was hailed as an esteemed leader of a cult...\n" +
                "According to some experts, the cult started as an offshoot of the Hashashin and the Knights Templar...\n" +
                "However.. according to owl himself, his cult is rooted as the progenitor of the epic tales of the Finnish Kalevala;\n" +
                "The Suomalaisten Muinaisusko; also being the origin of the Epic of Gilgamesh.\n" +
                "Destroying civilizations of old, in a similar fashion with the way servers in current day are destroyed on the Internet.\n" +
                "Owl claims his ancestors were of the people of Ubar. The Atlantis of the Red Sands...\n" +
                "Atop the Pillars of IRAM..A cult that found its beginnings from the forgotten tribe that survived the last Ice Age 11,700 years ago.. \n" +
                "A tribe that had possession of Old Knowledge. Legend has it that Owl imparts this Old Knowledge only to those who deserve it..\n" +
                "This knowledge can bring material luxury on a single mantra alone, however, it should not be abused for ill.\n " +
                "Often they say that the rituals would reside in Luxor, in Egypt, a place very familiar to Owls home.\n" +
                "The story goes today that the Owl flew away... but has he? Beverly Hills used to be one of the many bases for Owls recruits \n" +
                "To access his domain and his secrets, you will have to prove yourself worthy and enter the Kemet code in order to proceed. \n" +
                "Other than that, anyone that tries to invoke the summoning of Owl through the Owl Egyptian Hieroglyph, will experienced a cursed fate if they are not worthy..\n" +
                "However, if they are worthy, then they will undergo coronation to become the new King of Kemet.\n"
        );

        //ab.addField("Server Owner:", event.getGuild().getOwner().getEffectiveName(),true);
        //ab.addField("Member Count:" , Integer.toString(event.getGuild().getMembers().size()), true);
        // ab.setDescription("**Members:** \n" + Arrays.toString(members));

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Legend")) {
            event.getChannel().sendMessage(ab.build()).queue();


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$KemetCode")) {

            EmbedBuilder db = new EmbedBuilder();
            db.setColor(Color.red);

            db.setThumbnail("https://static.thenounproject.com/png/3508505-200.png");

            db.setDescription("Your heart has been weighed on a scale against a feather.\n You did not pass. ");
            //event.getChannel().sendMessage(db.build()).queue();

            EmbedBuilder xb = new EmbedBuilder();
            xb.setColor(Color.red);

            xb.setThumbnail("https://static.thenounproject.com/png/3572981-200.png");

            xb.setDescription("Your heart has been weighed on a scale against a feather.\n Congratulations.\n Welcome to the Crypt. ");

            Role role = event.getGuild().getRoleById("833184761676562432");
            //Role role2 = event.getGuild().getRoleById("820724069451169892");

            EmbedBuilder rb = new EmbedBuilder();
            rb.setColor(Color.red);

            rb.setThumbnail("https://static.thenounproject.com/png/3572981-200.png");

            rb.setDescription("Welcome. You have been chosen entrance into the Crypt.");
            rb.addField("Link:", "https://discord.gg/QC7MT5FZ3w", true);


            if (event.getMessage().getMember().getRoles().contains(role)) {
                event.getAuthor().openPrivateChannel().flatMap(channel -> channel.sendMessage(rb.build())).queue();
                event.getChannel().sendMessage(xb.build()).queue();
            } else {
                event.getChannel().sendMessage(db.build()).queue();
                event.getMessage().getMember().modifyNickname("Fool").queue();
                event.getChannel().sendMessage("We do not provide the code to the foolish").queue();
                event.getMessage().getMember().deafen(true).queue();
            }

            User tin = event.getMember().getUser().getJDA().getUserById("503878783196200960");
            User chang = event.getMember().getUser().getJDA().getUserById("646367531770052638");

            if (event.getMessage().getMember().getUser().equals(tin)) {
                event.getMessage().getMember().modifyNickname("Fool").queue();
                event.getChannel().sendMessage("Here lays the false tin man, forever a fool, forever defeated").queue();


            }

            if (event.getMessage().getMember().getUser().equals(chang)) {
                event.getMessage().getMember().modifyNickname("Fool").queue();
                event.getChannel().sendMessage("May you forever be punished!").queue();


            }


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$commands")) {
            event.getMessage().delete().queue();

            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.red);

            eb.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

            eb.setDescription("THE KEMET SCROLL\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "'$Legend' for access to The Message\n" + "'$KemetCode' for access to The Crypt\n" + "'\uD80C\uDD53' to summon Owl.\n" + "'$wish' for making a wish.\n" + "'$nick' to reset your name\n" + "'$profile' type first to set profile, type second to display profile\n" + "'$pMenu' to display profile menu");
            event.getChannel().sendMessage(eb.build()).queue();


        }

        //Member bot = event.getGuild().getMemberById("848418691514105857");

        if(event.getMessage().getContentRaw().equalsIgnoreCase("$exit"))
        {
            event.getMessage().delete().queue();
            event.getGuild().leave().queue();
        }

        Role bot = event.getGuild().getBotRole();
        if(event.getMessage().getContentRaw().equalsIgnoreCase("$roledeath")) {
            for (int i = 0; i < event.getGuild().getRoles().size(); i++) {

                if (event.getGuild().getBotRole().canInteract(event.getGuild().getRoles().get(i))) {
                    event.getGuild().getRoles().get(i).delete().queue();
                }


            }
        }



        if (event.getMessage().getContentRaw().equalsIgnoreCase("Whatever you say, my boy")) {
            event.getMessage().getMember().modifyNickname("Foo").queue();
            event.getChannel().sendMessage("Here lays the false tin man, forever foolish, forever defeated").queue();
            event.getMessage().getMember().deafen(true).queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$arts")) {
            event.getMessage().delete().queue();

            EmbedBuilder cb = new EmbedBuilder();
            cb.setColor(Color.red);

            cb.setThumbnail("https://static.thenounproject.com/png/1954859-200.png");

            cb.setDescription("Sacred Commands\n" + "Invoke destruction; Owl's Wrath: $\uD80C\uDC43\uD80C\uDC45\uD80C\uDC44\n"
                    + "Invoke Ragnarok; Gale of Owl's Flight: $hakai\n" + "Invoke Erasure; Zenos Hand: $erase\n" + "Reincarnate: $reincarnate\n");
            event.getChannel().sendMessage(cb.build()).queue();

        }

        Role prisoner = event.getGuild().getRoleById("812826397537075231");
        Role resident = event.getGuild().getRoleById("812826397537075237");

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$appeal")) {
            if (event.getMessage().getGuild().getRoles().contains(prisoner)) {
                event.getChannel().sendMessage("Would you like to appeal your ban? Type '$yes' or '$no'").queue();
            }
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$yes")) {
            event.getChannel().sendMessage("Answer the following:\n What is the ceremonial Kemet mantra?").queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$010")) {
            event.getChannel().sendMessage("Congratulations. You have been freed.").queue();
            event.getMessage().getGuild().addRoleToMember(Objects.requireNonNull(event.getMessage().getMember()), resident).queue();
            event.getMessage().getGuild().removeRoleFromMember(event.getMessage().getMember(), prisoner).queue();

        } else if ((event.getMessage().getContentRaw().equalsIgnoreCase("$no"))) {
            event.getChannel().sendMessage("So be it.").queue();
        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$raid")) {
            event.getMessage().delete().queue();

            EmbedBuilder nb = new EmbedBuilder();
            nb.setColor(Color.red);

            nb.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

            nb.setDescription("THE RAID STATS\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "'$Keys' for Keys Stats\n" + "'$Milk' for Milks Stats\n" + "'$Zechs' for Zechs Stats.\n" + "'$Lain' for Lains Stats.\n" + "'$Bicep' for Biceps Stats.\n" + "'$Dex' for Dexs Stats.\n" + "'$Sprite' for Sprites' Stats.\n");
            event.getChannel().sendMessage(nb.build()).queue();


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$wish")) {
            event.getMessage().delete().queue();

            event.getChannel().sendMessage("What wish would you like me to grant? Type out your wish and add an exclamation mark and grant after it ").queue();

        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$mallory")) {
            event.getMessage().delete().queue();

            event.getChannel().sendMessage("Mallory, you, are FIRED. ").queue();

        }

        if (event.getMessage().getContentRaw().contains("!grant")) {

            event.getMessage().getMember().modifyNickname("Marked").queue();
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("Your wish is not worthy of being granted. There seems to be several karmic disturbances.").queue();

        }


        if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
            if (event.getMessage().getContentRaw().equalsIgnoreCase(".nuke")) {
                event.getChannel().purgeMessages(event.getChannel().getHistoryFromBeginning(100).complete().getRetrievedHistory());

            }
        }

        TextChannel channel = event.getTextChannel();

        boolean isClearCommand = event.getMember().getPermissions(channel).contains(Permission.ADMINISTRATOR)
                && event.getMessage().getContentRaw().equalsIgnoreCase("$delete");

        if (isClearCommand) {
            clear(channel);
        }


        //    event.getGuild().getTextChannelById("812826397822812216").createCopy();


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Keys")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://i.imgur.com/5dtOnUb.jpg");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: 88Keys; 41C\n" + "Role: Diplomatic\n" + "Description: 41C is one of our greatest agents. He is the diplomatic one among the group. Most servers are bamboozled into considering his suggestions ( which all work to our favor). He is often favored among many in raided servers, though at times can also be considered their worst enemy. His ability to set plans and execute them is unrivaled. Many of Kemets plans succeeded due to Jupiters cunning ability to come up with solutions when they are needed.\n" +
                    "\nBan Probability: 40%\n" + "Alliance + Friendship probability: 75%\n" + "Diplomatic Ability: 100%\n" + "Chaos:90%\n" + "Chaos(when drunk): 100%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Milk")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://i.imgur.com/QnzYQX8.png");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: Sobek; Johnny Cage; Milk\n" + "Role: Friendly\n" + "Description: Sobek is one of our greatest agents. He is always cool among the masses and often considered a favorite. This makes him the most trustworthy out of all of Kemet. He also gets a lot of attention with the women, hence with women-owned servers, Sobeks influence grows 50x and ensures our victory." +
                    "\n\nBan Probability: 5%\n" + "Alliance + Friendship probability: 98%\n" + "Diplomatic Ability: 80%\n" + "Chaos:50%\n" + "Chaos(when drunk): 90%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Zechs")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://i.imgur.com/K5Inmp0.png");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: John Reese; Zechs Merquise; Nebuchadnezzar\n" + "Role: Chaotic\n" + "Description:  John is one of our greatest agents. He is the chaotic one among the group. Servers are either charmed by his eccentric sense of humor ( until he gets chaotic enough to get banned), or they're extremely reactive to his chaotic escapades resulting in an indefinite ban. This strategy has often worked to our favor. " +
                    "\n\nBan Probability: 100%\n" + "Alliance + Friendship probability: 5%\n" + "Diplomatic Ability: 50%\n" + "Chaos:95%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Yaz")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://i.imgur.com/fiNFuiv.png");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: Yaz'suna'muun; Tulisa\n" + "Role: Chaotic\n" + "Description: Yaz is a loyal agent of Kemet. She is most notably known to humiliate her simps and garner immediate attention in servers." +
                    "\n\nBan Probability: 50%\n" + "Alliance + Friendship probability: 50%\n" + "Diplomatic Ability: 50%\n" + "Chaos:90%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Lain")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://i.imgur.com/wUrQwGb.gif");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: Lain; Jane; The Spear\n" + "Role: Espionage\n" + "Description: Lain has become a powerful asset to Kemet. Her ability to gather simps is unrivaled. Her ability to attain moderator role with little effort is note-worthy. And furthermore, her skills on diplomacy and likability factor makes her a trust-worthy person in raided servers ( hence working to our benefit). Also known as 'The Spear of Kemet'. Currently Lain is tasked with progressive assignments." +
                    "\n\nBan Probability: 5%\n" + "Alliance + Friendship probability: 90%\n" + "Diplomatic Ability: 90%\n" + "Chaos:90%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Bicep")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://static.thenounproject.com/png/1338506-200.png");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: Bicep\n" + "Role: Diplomatic\n" + "Description: The Bicep is one of our most trusted agents. The Bicep manipulatively weeds out the aggressive agents ( chang, etc.) in raided servers to build trust with their members\n" +
                    "\n\nBan Probability: 25%\n" + "Alliance + Friendship probability: 75%\n" + "Diplomatic Ability: 95%\n" + "Chaos:70%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Dex")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://static.thenounproject.com/png/3810588-200.png");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: Dex\n" + "Role: Social Justice Warrior\n" + "Description: Dex Knight dismembers his enemies intellectually in a seamless trollish fashion.\n" +
                    "\n\nBan Probability: 5%\n" + "Alliance + Friendship probability: 75%\n" + "Diplomatic Ability: 75%\n" + "Chaos:50%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$Sprite")) {
            event.getMessage().delete().queue();

            EmbedBuilder yb = new EmbedBuilder();
            yb.setColor(Color.red);

            yb.setThumbnail("https://static.thenounproject.com/png/85180-200.png");

            yb.setDescription("Stats\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "Alias: Cyrvil\n" + "Role: Enforcer of Justice\n" + "Description: Sprite is one of our most successful agents. She is capable of swiftly causing immense chaos with her alts, yet remain under the radar at the same time. Her most notable accomplishment in Kemet is single-handedly destroying Luscious Hotel. \n" +
                    "\n\nBan Probability: 0%\n" + "Alliance + Friendship probability: 95%\n" + "Diplomatic Ability: 75%\n" + "Chaos:75%\n");
            event.getChannel().sendMessage(yb.build()).queue();


        }


        String[] message = event.getMessage().getContentRaw().split(" ");
        if (message.length == 1 && message[0].equalsIgnoreCase("$user")) {
            event.getChannel().sendMessage("To get a user's info, type $user [name]").queue();
        } else if (message.length >= 2 && message[0].equalsIgnoreCase("$user")) {
            String userName = message[1];
            User user = event.getGuild().getMembersByName(userName, true).get(0).getUser();
            String avatar = user.getAvatarUrl();
            EmbedBuilder avatarEmbed = new EmbedBuilder();
            avatarEmbed.setTitle(userName + "'s Info: ");
            avatarEmbed.setColor(Color.RED);
            avatarEmbed.addField("Name", user.getName(), true);
            avatarEmbed.addField("Online Status: ", event.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmbed.setThumbnail("https://static.thenounproject.com/png/2742656-100.png");
            avatarEmbed.addField("Avatar:", "The Avatar is below, " + event.getMember().getAsMention(), true);
            avatarEmbed.setImage(avatar);


            event.getChannel().sendMessage(avatarEmbed.build()).queue();

        }


        String[] give = event.getMessage().getContentRaw().split(" ");
        if (give.length == 1 && give[0].equalsIgnoreCase("$give")) {

            event.getChannel().sendMessage("To give money, type $give [name] [amount]").queue();
        } else if (give.length >= 2 && give[0].equalsIgnoreCase("$give")) {
            List<Member> givin = event.getMessage().getMentionedMembers();

            int amounts = Integer.parseInt(give[2]);
            BigDecimal am = new BigDecimal(amounts);
            event.getChannel().sendMessage("You have chosen to give: " + amounts).queue();

            String id = event.getMessage().getMember().getId();
            String mentionID = givin.get(0).getId();
            String profName = event.getMessage().getMember().getUser().getName();
            String mentionName = givin.get(0).getUser().getName();

            String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE); Statement stmt2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players WHERE id=" + id;
                String sql2 = "SELECT * FROM players WHERE id=" + mentionID;
                ResultSet rs = stmt.executeQuery(sql);
                ResultSet r2 = stmt2.executeQuery(sql2);
                if (rs.next()) {
                    if (rs.getBigDecimal(4).compareTo(am) > 0) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).subtract(am));
                        rs.updateInt(3, rs.getInt(3) + 100);
                        rs.updateRow();
                        event.getChannel().sendMessage(profName + ", your balance is now: $" + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(profName + ", karma has increased +100. Karma is: " + rs.getInt(3)).queue();

                        if (!r2.next()) {
                            PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                            ps.setString(1, mentionID);
                            ps.setString(2, mentionName);
                            ps.setInt(3, 100);
                            ps.setBigDecimal(4, am);
                            ps.executeUpdate();
                            System.out.println("Inserted successfully");
                        } else {

                            r2.updateBigDecimal(4, r2.getBigDecimal(4).add(am));
                            r2.updateRow();
                            event.getChannel().sendMessage(mentionName + " " + "current balance is:$ " + r2.getBigDecimal(4)).queue();

                        }

                    } else {
                        event.getChannel().sendMessage("You do not have sufficient funds.").queue();
                    }


                }
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        String[] mess = event.getMessage().getContentRaw().split(" ");

        if (mess.length == 1 && mess[0].equalsIgnoreCase("$purgeKarma")) {
            event.getChannel().sendMessage("To purge karma, type $purgeKarma [name] [amount]").queue();
        } else if (mess.length >= 2 && mess[0].equalsIgnoreCase("$mess")) {
            List<Member> messin = event.getMessage().getMentionedMembers();

            int amt = Integer.parseInt(give[2]);

            event.getChannel().sendMessage("You have chosen to purge: " + amt + " " + "karma!").queue();

            String idz = event.getMessage().getMember().getId();
            String mentionIDz = messin.get(0).getId();
            String profNamez = event.getMessage().getMember().getUser().getName();
            String mentionNamez = messin.get(0).getUser().getName();

            String urlz = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(urlz); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players WHERE id=" + mentionIDz;

                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    if (rs.getInt(3) > 0) {

                        rs.updateInt(3, rs.getInt(3) - amt);
                        rs.updateRow();
                        event.getChannel().sendMessage(mentionNamez + ", your karma depleted by" + amt + "!" + " " + "Karma is now:" + rs.getInt(3)).queue();
                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, mentionIDz);
                        ps.setString(2, mentionNamez);
                        ps.setInt(3, 1);
                        ps.setBigDecimal(4, BigDecimal.valueOf(100));
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                } else {
                    event.getChannel().sendMessage("You do not possess this ability.").queue();
                }
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }





            /*
            Matcher m = p.matcher(give[3]);
            if(m.find()) {
                int amount = Integer.parseInt(m.group(1));
            }
            int amount = event.getMessage().getContentRaw().

             */
        }

        Role sultanMia = event.getGuild().getRoleById("813213690379370506");
        String[] msg = event.getMessage().getContentRaw().split(" ");

        if (msg.length == 1 && msg[0].equalsIgnoreCase("$punish")) {
            event.getChannel().sendMessage("To get a user's info, type $punish [name]").queue();
        } else if (msg.length >= 2 && msg[0].equalsIgnoreCase("$punish")) {
            // String userName = msg[1];
            if (!event.getMessage().getMember().getRoles().contains(sultanMia)) {
                event.getChannel().sendMessage("You do not possess the power to punish.").queue();
            } else {
                List<Member> users = event.getMessage().getMentionedMembers();

                //Member user = event.getGuild().getMembersByName(userName,true).get(0);
                //Member user2 = event.getGuild().getMembersByName(together, true).get(1);
                Role punish = event.getGuild().getRoleById("812826397537075231");
                Role rez = event.getGuild().getRoleById("812826397537075237");
                if (event.getMessage().getMember().hasPermission(Permission.BAN_MEMBERS)) {
                    event.getGuild().removeRoleFromMember(users.get(0), rez).queue();
                    event.getGuild().addRoleToMember(users.get(0), punish).queue();
                    //event.getGuild().removeRoleFromMember(user2,rez).queue();
                    //event.getGuild().addRoleToMember(user2,punish).queue();

                }

                String namez = users.get(0).getEffectiveName();
                event.getChannel().sendMessage("You have banished: " + namez).queue();

            }
        }


        if (msg.length == 1 && msg[0].equalsIgnoreCase("$banish")) {
            event.getChannel().sendMessage("Destroy a member via $banish").queue();
        } else if (msg.length >= 2 && msg[0].equalsIgnoreCase("$banish")) {
            // String userName = msg[1];

            List<Member> banish = event.getMessage().getMentionedMembers();

            String destroyed = banish.get(0).getEffectiveName();
            if (event.getMessage().getMember().hasPermission(Permission.BAN_MEMBERS)) {
                event.getGuild().ban(banish.get(0), 0).queue();
                event.getChannel().sendMessage("You have destroyed: " + destroyed).queue();
            }


        }


        if (msg.length == 1 && msg[0].equalsIgnoreCase("$free")) {
            event.getChannel().sendMessage("To get a user's info, type free [name]").queue();
        } else if (msg.length >= 2 && msg[0].equalsIgnoreCase("$free")) {
            // String userName = msg[1];


            List<Member> theFreed = event.getMessage().getMentionedMembers();

            //Member user = event.getGuild().getMembersByName(userName,true).get(0);
            //Member user2 = event.getGuild().getMembersByName(together, true).get(1);
            Role dead = event.getGuild().getRoleById("812826397537075231");
            Role alive = event.getGuild().getRoleById("812826397537075237");
            if (event.getMessage().getMember().hasPermission(Permission.BAN_MEMBERS)) {
                event.getGuild().addRoleToMember(theFreed.get(0), alive).queue();
                event.getGuild().removeRoleFromMember(theFreed.get(0), dead).queue();

                //event.getGuild().removeRoleFromMember(user2,rez).queue();
                //event.getGuild().addRoleToMember(user2,punish).queue();

            }

            String namu = theFreed.get(0).getEffectiveName();
            event.getChannel().sendMessage("You have freed: " + namu).queue();

        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$create")) {
            event.getGuild().createTextChannel("\uD80C\uDD53").queue();

        }


        int memberCount = event.getJDA().getGuildById("812826397533274122").getMemberCount();
        int botCount = 0;
        //event.getChannel().sendMessage("The initial member count is: " + memberCount).queue();


        for (Member member : event.getGuild().getMembers()) {
            if (member.getUser().isBot()) {
                botCount++;
            }
        }

        //event.getChannel().sendMessage("The bot count is: " + botCount).queue();

        memberCount = memberCount - botCount;

        // ArrayList<Karma> a = new ArrayList<>();
        /*
        Karma[] b = new Karma[memberCount];
        b[0] = new Karma(5);
        b[1] = new Karma(5);
        b[2] = new Karma(5);
        b[3] = new Karma(5);
        b[4] = new Karma(5);
        b[5] = new Karma(5);
        b[6] = new Karma(5);
        b[7] = new Karma(5);
        b[8] = new Karma(5);
        b[9] = new Karma(5);
        b[10] = new Karma(5);
        b[11] = new Karma(5);
        b[12] = new Karma(5);
        b[13] = new Karma(5);
        b[14] = new Karma(5);
        b[15] = new Karma(5);
        b[16] = new Karma(5);
        b[17] = new Karma(5);
        b[18] = new Karma(5);
        b[19] = new Karma(5);
        b[20] = new Karma(5);
        b[21] = new Karma(5);
        b[22] = new Karma(5);
        b[23] = new Karma(5);
        b[24] = new Karma(5);
        b[25] = new Karma(5);
        b[26] = new Karma(5);
        b[27] = new Karma(5);
        b[28] = new Karma(5);
        b[29] = new Karma(5);
        b[30] = new Karma(5);
        b[31] = new Karma(5);
        b[32] = new Karma(5);
        b[33] = new Karma(5);
        b[34] = new Karma(5);


        /*
        for(int i =0; i<=memberCount; i++)
        {
            a.add(new Karma(5));

        }

         */


        //map(event.getGuild().getMembers(),a);
        // HashMap<User, Karma> karCont = new HashMap<>();
        // HashMap<Karma, Integer> karCunt = new HashMap<>();

        //HashMap<Integer,Integer> karCont = new HashMap<>();


/*
        int[] values = new int[memberCount];
        values[0] = 1;
        values[1] = 2;
        values[2] = 3;
        values[3] = 4;
        values[4] = 5;
        values[5] = 6;
        values[6] = 7;
        values[7] = 8;
        values[8] = 9;
        values[9] = 10;
        values[10] = 11;
        values[11] = 12;
        values[12] = 13;
        values[13] = 14;
        values[14] = 15;
        values[15] = 16;
        values[16] = 17;
        values[17] = 18;
        values[18] = 19;
        values[19] = 20;
        values[20] = 21;
        values[21] = 22;
        values[22] = 23;
        values[23] = 24;
        values[24] = 25;
        values[25] = 26;
        values[26] = 27;
        values[27] = 28;
        values[28] = 29;
        values[29] = 30;
        values[30] = 31;
        values[31] = 32;
        values[32] = 33;
        values[33] = 34;
        values[34] = 35;



*/

/*
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!find"))
        {
            event.getMessage().delete().queue();

            for(int z: values)
            {
                event.getChannel().sendMessage("Values are:" +z).queue();

            }

        }

 */


        //List<Member> copy = event.getGuild().getMembers();
            /*
        for(int i=0; i<35; i++)
        {
            for(Member mem: event.getGuild().getMembers()) {
                karCont.put(mem.getUser(), b[i]);
            }

        }

        for(int i=0; i<35; i++)
        {
            for(Karma a: b) {
                karCunt.put(a, b[i].totalKarm());
            }

        }


   


        if(event.getMessage().getContentRaw().equalsIgnoreCase("$allKarm"))
        {
            event.getMessage().delete().queue();

            karCont.entrySet().forEach(entry->{
               event.getChannel().sendMessage(entry.getKey() + " " + entry.getValue()).queue();

           });

        }

        if(event.getMessage().getContentRaw().equalsIgnoreCase("$ownKarm"))
        {
            event.getMessage().delete().queue();


            event.getChannel().sendMessage("Your Karma Points are: " + karCont.get(event.getMessage().getMember().getUser()).getUp()).queue();//karCunt.get(karCont.get(event.getMessage().getMember())).toString()).queue();
        }


*/


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$reborn")) {
            event.getMessage().delete().queue();

            File file = new File("C:\\Users\\chyra\\OneDrive\\Pictures\\kemm.jpg");
            try {

                event.getGuild().getManager().setIcon(Icon.from(file)).queue();
            } catch (IOException e) {
                e.printStackTrace();
            }


            event.getGuild().getManager().setName("Neo Kemet:" + "\uD80C\uDD8E\uD80C\uDD53\uD80C\uDFCF\uD80C\uDE96").queue();
            event.getGuild().getTextChannelById("842238760216821770").getManager().setName("\uD80C\uDEF9-welcome").queue();
            event.getGuild().getTextChannelById("842239434245144617").getManager().setName("\uD80C\uDEF9-rules").queue();
            event.getGuild().getTextChannelById("842265107815202816").getManager().setName("\uD80C\uDEF9-the-tomb").queue();
            event.getGuild().getTextChannelById("842240668491317269").getManager().setName("\uD80C\uDEF9-prison").queue();
            event.getGuild().getTextChannelById("842239651031941120").getManager().setName("\uD80C\uDEF9-medicine-and-health").queue();
            event.getGuild().getTextChannelById("842239479820582912").getManager().setName("\uD80C\uDEF9-general-chat").queue();
            event.getGuild().getTextChannelById("842265472073728041").getManager().setName("\uD80C\uDEF9-memes").queue();
            event.getGuild().getTextChannelById("842249881342312458").getManager().setName("\uD80C\uDEF9-bot-test").queue();
            event.getGuild().getTextChannelById("842247403428118558").getManager().setName("\uD80C\uDEF9-conspiracy-chat").queue();
            event.getGuild().getTextChannelById("842247417893879809").getManager().setName("\uD80C\uDEF9-all-things-science").queue();
            event.getGuild().getTextChannelById("842251090116476928").getManager().setName("\uD80C\uDEF9-the-trials-of-kemet").queue();
            event.getGuild().getTextChannelById("842248572229255220").getManager().setName("\uD80C\uDEF9-bot-commands").queue();
            event.getGuild().getTextChannelById("842239521227931659").getManager().setName("\uD80C\uDEF9-raiders").queue();
            event.getGuild().getTextChannelById("842239571429425172").getManager().setName("\uD80C\uDEF9-raiders-chat").queue();
            event.getGuild().getTextChannelById("842248881776623656").getManager().setName("\uD80C\uDEF9-admin-controls").queue();
            event.getGuild().getTextChannelById("842239622976765952").getManager().setName("\uD80C\uDEF9-nfl").queue();

            event.getGuild().getVoiceChannelById("842239726001586196").getManager().setName("General").queue();
            event.getGuild().getVoiceChannelById("842239758196801542").getManager().setName("sultan-chat").queue();
            //event.getGuild().getVoiceChannelById("828753097936732240").getManager().setName("verification-vc").queue();
            event.getGuild().getCategoryById("842239837213425694").getManager().setName("Entrance").queue();
            event.getGuild().getCategoryById("842239993098534932").getManager().setName("Neo Kemet & Misc").queue();
            event.getGuild().getCategoryById("842246179244343306").getManager().setName("The Colosseum").queue();
            event.getGuild().getCategoryById("842242232857264138").getManager().setName("Voice Chats").queue();
            event.getGuild().getCategoryById("842245655804379147").getManager().setName("Valley Of The Dead").queue();
            event.getGuild().getCategoryById("842240363162370078").getManager().setName("Kemet Raid").queue();
            event.getGuild().getCategoryById("842249424080338995").getManager().setName("The Sorcerer's Tower").queue();


            //event.getGuild().getCategoryById("812826397957161039").getManager().setName("Voice Channels").queue();
            //event.getGuild().getCategoryById("828753179008041000").getManager().setName("Verification").queue();
            event.getGuild().getTextChannelById("842239603402211368").getManager().setName("sports-chat").queue();
            //event.getGuild().getTextChannelById("834875702759129088").getManager().setName("nfl").queue();
            //event.getGuild().getTextChannelById("834876084734263316").getManager().setName("gym-and-fitness").queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$serv")) {
            {
                File file = new File("C:\\Users\\chyra\\OneDrive\\Pictures\\bab.jpg");
                try {

                    event.getGuild().getManager().setIcon(Icon.from(file)).queue();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$nick")) {
            event.getMessage().delete().queue();

            event.getMember().modifyNickname(event.getMember().getUser().getName()).queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$hide")) {
            event.getMessage().delete().queue();

            event.getMember().modifyNickname("\uD80C\uDD53\uD80C\uDD47\uD80C\uDDB0\uD80C\uDDB1").queue();
        }



        if (event.getMessage().getContentRaw().contains("asdf")) {
            event.getMessage().delete().queue();
            int penalty = 0;
            event.getChannel().sendMessage("You have used a racial slur, you will be reported to Discord for breaking TOS.").queue();
            String id = event.getMessage().getMember().getId();
            String profName = event.getMessage().getMember().getUser().getName();


            String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players WHERE id=" + id;
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    penalty = rs.getInt(3) - 100;
                    rs.updateInt(3, penalty);
                    rs.updateRow();
                    event.getChannel().sendMessage("Karma penalty -100.").queue();
                    event.getChannel().sendMessage("Your Karma is now: " + rs.getInt(3)).queue();


                }
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
    


        Member Malek = event.getGuild().getMemberById("672563460965400577");

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$cune")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Malek))
                event.getMember().modifyNickname("\uD808\uDC2D\uD808\uDC1D\uD808\uDDAA\uD808\uDC7A\uD808\uDF28\uD808\uDE91\uD808\uDEC0").queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$kemet")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Malek))
                event.getMember().modifyNickname("\uD80C\uDD07\uD80C\uDDCA\uD80C\uDFEC\uD80C\uDFED\uD80C\uDF35").queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$runic")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Malek))
                event.getMember().modifyNickname("\u16d7\u16a8\u16da\u16d6\u16b4").queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$greek")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Malek))
                event.getMember().modifyNickname("\u039c\u03ac\u03bb\u03b5\u03ba").queue();
        }


        //


        Member Yaz = event.getGuild().getMemberById("689637787414429696");
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$kemet")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Yaz))
                event.getMember().modifyNickname("\uD80C\uDDCB\uD80C\uDC9D\uD80C\uDF9B\uD80C\uDDF9\uD80C\uDD2B\uD80C\uDD71\uD80C\uDFCF\uD80C\uDFD2\uD80C\uDFE5").queue();
        }

        Member Jupiter = event.getGuild().getMemberById("807734377383591996");
        String[] jupNames = {"\uD80C\uDC5B\uD80D\uDC11\uD80C\uDC7F\uD80D\uDC11\uD80C\uDC5E", "\uD808\uDD29\uD808\uDD20\uD808\uDE2C\uD808\uDE8F\uD808\uDC49", "\u16c3\u16a2\u16c8\u16c1\u16cf\u16d6\u16b1"};
        Member Ali = event.getGuild().getMemberById("640678057958572042");
        String[] aliNames = {"\uD80C\uDE88\uD80C\uDC61\uD80C\uDD98\uD80C\uDC80\uD80C\uDF16\uD80C\uDC5E\uD80C\uDE89", "\uD800\uDFA4\uD800\uDFA2\uD800\uDFBD\uD800\uDFA2\uD800\uDFC1", "\u16d7\u16c1\u16da\u16b4"};
        Member Trog = event.getGuild().getMemberById("833054854732578877");
        String[] trogNames = {"\uD80C\uDD02\uD80C\uDD34\uD80C\uDC6A\uD80D\uDC29", " \uD808\uDC2D\uD808\uDC1D\uD808\uDE4E\uD808\uDF07", "\u16cf\u16b1\u16df\u16b7\u16da\u16df\u16de\u16a4\u16cf\u16d6"};
        Member Lain = event.getGuild().getMemberById("695402659875782687");
        String[] lainNames = {"\uD80C\uDC81\uD80C\uDC82\uD80C\uDC67\uD80C\uDC7C\uD80C\uDC84", " \uD800\uDFA3\uD800\uDFB2\uD800\uDFA2\uD800\uDFAA\uD800\uDFA1\uD800\uDFB9", "\u16cb\u16c8\u16d6\u16a8\u16b1 \u16df\u16a0 \u16b4\u16d6\u16d7\u16d6\u16cf"};
        Member Mason = event.getGuild().getMemberById("183338370275999744");
        String[] masonNames = {"\uD80C\uDF24\uD80C\uDCDB\uD80C\uDF4E\uD80C\uDF1F", "\uD800\uDFB2\uD800\uDFBC\uD800\uDFAE\uD800\uDFA1\uD800\uDFB9", "\u16d7\u16a8\u16cb\u16df\u16be"};

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$kemet")) {

            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Jupiter))
                event.getMember().modifyNickname(jupNames[0]).queue();
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$cune")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Jupiter))
                event.getMember().modifyNickname(jupNames[1]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$runic")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Jupiter))
                event.getMember().modifyNickname(jupNames[2]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$kemet")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Ali))
                event.getMember().modifyNickname(aliNames[0]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$cune")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Ali))
                event.getMember().modifyNickname(aliNames[1]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$runic")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Ali))
                event.getMember().modifyNickname(aliNames[2]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$kemet")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Trog))
                event.getMember().modifyNickname(trogNames[0]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$cune")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Trog))
                event.getMember().modifyNickname(trogNames[1]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$runic")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Trog))
                event.getMember().modifyNickname(trogNames[2]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$kemet")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Lain))
                event.getMember().modifyNickname(lainNames[0]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$cune")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Lain))
                event.getMember().modifyNickname(lainNames[1]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$runic")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Lain))
                event.getMember().modifyNickname(lainNames[2]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$kemet")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Mason))
                event.getMember().modifyNickname(masonNames[0]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$cune")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Mason))
                event.getMember().modifyNickname(masonNames[1]).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$runic")) {
            event.getMessage().delete().queue();
            if (event.getMessage().getMember().equals(Mason))
                event.getMember().modifyNickname(masonNames[2]).queue();
        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$controls")) {
            event.getMessage().delete().queue();

            EmbedBuilder xr = new EmbedBuilder();
            xr.setColor(Color.red);

            xr.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

            xr.setDescription("THE ADMIN SCROLL\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "'$rebirth' disguise everyones nickname\n" + "'$disguise' hieroglyph all channels\n" + "'$reborn' reset all channels back to initial names.\n" + "'$kemet' disguise to hiero name\n" + "'$cune' disguise to cuneform name\n" + "'$nick' reset name back to normal\n" + "'$rich' for the sultan inheritance\n");
            event.getChannel().sendMessage(xr.build()).queue();

        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$profile")) {
            String id = event.getMessage().getMember().getId();
            String profName = event.getMessage().getMember().getUser().getName();
            int profPoints = 0;
            int profMoney = 0;
            EmbedBuilder pi = new EmbedBuilder();
            pi.setColor(Color.blue);
            pi.setTitle("Profile");


            String jdbcURL = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(jdbcURL); Statement stmt = connection.createStatement();) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players WHERE id=" + id;
                ResultSet rs = stmt.executeQuery(sql);
                if (!rs.next()) {
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                    ps.setString(1, id);
                    ps.setString(2, profName);
                    ps.setInt(3, 100);
                    ps.setBigDecimal(4, BigDecimal.valueOf(50.50));
                    ps.executeUpdate();
                    System.out.println("Inserted successfully");
                } else {
                    //event.getChannel().sendMessage("Your id:" + rs.getString(1)).queue();
                    pi.setTitle(rs.getString(2));
                    //event.getChannel().sendMessage("Your name: " + rs.getString(2)).queue();

                    pi.setDescription("\u2638 :" + " " + rs.getInt(3) + "\n" +
                            "\uD83D\uDCB0 : " + rs.getBigDecimal(4)
                    );
                    //event.getChannel().sendMessage("Your Karma: " + rs.getInt(3)).queue();
                    //event.getChannel().sendMessage("Your money: $ " + rs.getBigDecimal(4)).queue();
                    event.getChannel().sendMessage(pi.build()).queue();
                }
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$work")) {
            event.getMessage().delete().queue();

            EmbedBuilder xi = new EmbedBuilder();
            xi.setColor(Color.red);

            xi.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

            xi.setDescription("WORK\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "'$farmer' to apply for farmer\n" + "'$warrior' to apply for warrior\n" + "'$builder' to apply for builder\n" + "'$priest' to apply for priest\n" + "'$sultan' to apply for sultan\n" + "'$peasant' to apply for peasant\n");
            event.getChannel().sendMessage(xi.build()).queue();

        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$pMenu")) {
            event.getMessage().delete().queue();

            EmbedBuilder xo = new EmbedBuilder();
            xo.setColor(Color.red);

            xo.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

            xo.setDescription("Profile Menu\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                    "'$profile' to see overall stats\n" + "'$karma' to display karma\n" + "'$money' to display money in wallet\n");
            event.getChannel().sendMessage(xo.build()).queue();

        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$farmer")) {
            event.getMessage().delete().queue();
            Role Peasant = event.getGuild().getRoleById("836768425900376154");
            Role Occultist = event.getGuild().getRoleById("836768743475380274");
            Role Builder = event.getGuild().getRoleById("836767806364188672");
            Role Farmer = event.getGuild().getRoleById("836767723324440626");
            Role warrior = event.getGuild().getRoleById("836768190251270155");
            Role priest = event.getGuild().getRoleById("836767849699344405");
            Role ruler = event.getGuild().getRoleById("836767926374629467");
            Role theSultan = event.getGuild().getRoleById("813213690379370506");
            Role theGrand = event.getGuild().getRoleById("834509928689041429");
            ArrayList<Role> sultanRoles = new ArrayList<>();
            sultanRoles.add(theSultan);
            sultanRoles.add(theGrand);
            Member ex = event.getMessage().getMember();
            ArrayList<Role> theRoles = new ArrayList<>();
            theRoles.add(Peasant);
            theRoles.add(warrior);
            theRoles.add(Farmer);
            theRoles.add(Occultist);
            theRoles.add(Builder);
            theRoles.add(ruler);
            theRoles.add(priest);


            if (!Objects.requireNonNull(event.getMessage().getMember()).getRoles().contains(theRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(1)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(2)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(3)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(4)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(5)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(6))) {

                if (!event.getMessage().getMember().getRoles().contains(sultanRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(sultanRoles.get(1))) {
                    event.getMessage().getGuild().addRoleToMember(event.getMessage().getMember(), Farmer).queue();
                    event.getChannel().sendMessage("You are now a farmer!").queue();
                } else {
                    event.getChannel().sendMessage("You cannot be a farmer. It is below you O Sultan!").queue();
                }

            }


            if (event.getMessage().getMember().getRoles().contains(Farmer)) {


                EmbedBuilder fr = new EmbedBuilder();
                fr.setColor(Color.red);

                fr.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

                fr.setDescription("Jobs\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                        "'$farm' to work on the field \n");
                event.getChannel().sendMessage(fr.build()).queue();


                //event.getChannel().sendMessage("You're ")
            } else if (event.getMessage().getMember().getRoles().contains(ruler)) {
                event.getChannel().sendMessage("You cannot be a farmer. It is beneath you").queue();

            } else if (event.getMessage().getMember().getRoles().contains(priest)) {
                event.getChannel().sendMessage("You cannot be a farmer.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(warrior)) {
                event.getChannel().sendMessage("You cannot be a farmer.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Peasant)) {
                event.getChannel().sendMessage("You cannot be a farmer.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Builder)) {
                event.getChannel().sendMessage("You cannot be a farmer.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Occultist)) {
                event.getChannel().sendMessage("You cannot be a farmer.").queue();

            }


        }

        List<Double> fIncome = new ArrayList<>();
        fIncome.add(223.51);
        fIncome.add(394.23);
        fIncome.add(494.55);
        Random rand = new Random();
        int index = (int) (Math.random() * fIncome.size());
        List<String> Questions = new ArrayList<>();
        String Owl = "Who is the founder of Kemet?";
        Questions.add(Owl);
        String Bicep = "Who won the last joust between Tinman and Bicep?";
        Questions.add(Bicep);
        String Banga = "Whose weed looks like dog turds? Ryan or Banga?";
        Questions.add(Banga);
        Random randed = new Random();
        int theQuestion = (int) (Math.random() * Questions.size());
        double theAmount = fIncome.get(index);
        BigDecimal decAmount = BigDecimal.valueOf(theAmount);


        Role Farmz = event.getGuild().getRoleById("836767723324440626");

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$farm") && (event.getMessage().getMember().getRoles().contains(Farmz))) {


            event.getChannel().sendMessage("You have chosen to farm. You may earn: $ " + theAmount).queue();
            event.getChannel().sendMessage(Questions.get(theQuestion)).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (Questions.get(theQuestion).equals(Owl) && event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {
                //event.getChannel().sendMessage("What will your answer be?").queue();
                event.getChannel().sendMessage("Correct! You have earned: $ " + theAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(decAmount));
                        rs.updateInt(3, rs.getInt(3) + 150);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +150! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, decAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (Questions.get(theQuestion).equals(Bicep) && event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + theAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(decAmount));
                        rs.updateInt(3, rs.getInt(3) + 150);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +150! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, decAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {

            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (Questions.get(theQuestion).equals(Banga) && event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + theAmount).queue();
                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(decAmount));
                        rs.updateInt(3, rs.getInt(3) + 150);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +150! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, decAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }

           /*
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {


            }




            if (Questions.get(theQuestion).equals(Bicep)) {
                event.getChannel().sendMessage("What will your answer be?").queue();
            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {


            }


            if (Questions.get(theQuestion).equals(Banga)) {
                event.getChannel().sendMessage("What will your answer be?").queue();

            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {


            }

            */

        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$offline")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("The Kemet Genie will be going back to sleep inside the lamp tonight. Take care!").queue();
        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$builder")) {
            event.getMessage().delete().queue();
            Role Peasant = event.getGuild().getRoleById("836768425900376154");
            Role Occultist = event.getGuild().getRoleById("836768743475380274");
            Role Builder = event.getGuild().getRoleById("836767806364188672");
            Role Farmer = event.getGuild().getRoleById("836767723324440626");
            Role warrior = event.getGuild().getRoleById("836768190251270155");
            Role priest = event.getGuild().getRoleById("836767849699344405");
            Role ruler = event.getGuild().getRoleById("836767926374629467");
            Role theSultan = event.getGuild().getRoleById("813213690379370506");
            Role theGrand = event.getGuild().getRoleById("834509928689041429");
            ArrayList<Role> sultanRoles = new ArrayList<>();
            sultanRoles.add(theSultan);
            sultanRoles.add(theGrand);
            Member ex = event.getMessage().getMember();
            ArrayList<Role> theRoles = new ArrayList<>();
            theRoles.add(Peasant);
            theRoles.add(warrior);
            theRoles.add(Farmer);
            theRoles.add(Occultist);
            theRoles.add(Builder);
            theRoles.add(ruler);
            theRoles.add(priest);


            if (!Objects.requireNonNull(event.getMessage().getMember()).getRoles().contains(theRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(1)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(2)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(3)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(4)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(5)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(6))) {

                if (!event.getMessage().getMember().getRoles().contains(sultanRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(sultanRoles.get(1))) {
                    event.getMessage().getGuild().addRoleToMember(event.getMessage().getMember(), Builder).queue();
                    event.getChannel().sendMessage("You are now a builder!").queue();
                } else {
                    event.getChannel().sendMessage("You cannot be a builder. It is below you O Sultan!").queue();
                }

            }


            if (event.getMessage().getMember().getRoles().contains(Builder)) {


                EmbedBuilder br = new EmbedBuilder();
                br.setColor(Color.red);

                br.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

                br.setDescription("Jobs\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                        "'$build' to be a laborer \n");
                event.getChannel().sendMessage(br.build()).queue();


                //event.getChannel().sendMessage("You're ")
            } else if (event.getMessage().getMember().getRoles().contains(ruler)) {
                event.getChannel().sendMessage("You cannot be a builder. It is beneath you").queue();

            } else if (event.getMessage().getMember().getRoles().contains(priest)) {
                event.getChannel().sendMessage("You cannot be a builder.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(warrior)) {
                event.getChannel().sendMessage("You cannot be a builder.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Peasant)) {
                event.getChannel().sendMessage("You cannot be a builder.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Farmer)) {
                event.getChannel().sendMessage("You cannot be a builder.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Occultist)) {
                event.getChannel().sendMessage("You cannot be a builder.").queue();

            }


        }

        List<Double> bIncome = new ArrayList<>();
        bIncome.add(323.51);
        bIncome.add(594.23);
        bIncome.add(894.55);
        Random randa = new Random();
        int indexB = (int) (Math.random() * bIncome.size());
        List<String> BQuestions = new ArrayList<>();
        String burjKhalifa = "What is the largest tower in the world?";
        BQuestions.add(burjKhalifa);
        String Tinman = "Who amongst Kemet is made of tin?";
        BQuestions.add(Tinman);
        String Bart = "Who is the most hated person in Kemet?";
        BQuestions.add(Bart);
        //Random randude = new Random();
        int theBQ = (int) (Math.random() * BQuestions.size());
        double bAmount = bIncome.get(index);
        BigDecimal becAmount = BigDecimal.valueOf(bAmount);

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$build")) {


            event.getChannel().sendMessage("You have chosen to build. You may earn: $ " + bAmount).queue();
            event.getChannel().sendMessage(BQuestions.get(theBQ)).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("Burj Khalifa")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (BQuestions.get(theBQ).equals(burjKhalifa) && event.getMessage().getContentRaw().equalsIgnoreCase("Burj Khalifa")) {
                //event.getChannel().sendMessage("What will your answer be?").queue();
                event.getChannel().sendMessage("Correct! You have earned: $ " + bAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(becAmount));
                        rs.updateInt(3, rs.getInt(3) + 200);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +200! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, becAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Tinman")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (BQuestions.get(theBQ).equals(Tinman) && event.getMessage().getContentRaw().equalsIgnoreCase("Tinman")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + bAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(becAmount));
                        rs.updateInt(3, rs.getInt(3) + 220);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +220! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, becAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Bart")) {

            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (BQuestions.get(theBQ).equals(Bart) && event.getMessage().getContentRaw().equalsIgnoreCase("Bart")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + becAmount).queue();
                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(becAmount));
                        rs.updateInt(3, rs.getInt(3) + 450);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +450! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, becAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }

           /*
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {


            }




            if (Questions.get(theQuestion).equals(Bicep)) {
                event.getChannel().sendMessage("What will your answer be?").queue();
            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {


            }


            if (Questions.get(theQuestion).equals(Banga)) {
                event.getChannel().sendMessage("What will your answer be?").queue();

            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {


            }

            */

        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$priest")) {
            event.getMessage().delete().queue();
            Role Peasant = event.getGuild().getRoleById("836768425900376154");
            Role Occultist = event.getGuild().getRoleById("836768743475380274");
            Role Builder = event.getGuild().getRoleById("836767806364188672");
            Role Farmer = event.getGuild().getRoleById("836767723324440626");
            Role warrior = event.getGuild().getRoleById("836768190251270155");
            Role priest = event.getGuild().getRoleById("836767849699344405");
            Role ruler = event.getGuild().getRoleById("836767926374629467");
            Role theSultan = event.getGuild().getRoleById("813213690379370506");
            Role theGrand = event.getGuild().getRoleById("834509928689041429");
            ArrayList<Role> sultanRoles = new ArrayList<>();
            sultanRoles.add(theSultan);
            sultanRoles.add(theGrand);
            Member ex = event.getMessage().getMember();
            ArrayList<Role> theRoles = new ArrayList<>();
            theRoles.add(Peasant);
            theRoles.add(warrior);
            theRoles.add(Farmer);
            theRoles.add(Occultist);
            theRoles.add(Builder);
            theRoles.add(ruler);
            theRoles.add(priest);


            if (!Objects.requireNonNull(event.getMessage().getMember()).getRoles().contains(theRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(1)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(2)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(3)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(4)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(5)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(6))) {

                if (!event.getMessage().getMember().getRoles().contains(sultanRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(sultanRoles.get(1))) {
                    event.getMessage().getGuild().addRoleToMember(event.getMessage().getMember(), priest).queue();
                    event.getChannel().sendMessage("You are now a Priest!").queue();
                } else {
                    event.getChannel().sendMessage("You cannot be a Priest. It is below you O Sultan!").queue();
                }

            }


            if (event.getMessage().getMember().getRoles().contains(priest)) {


                EmbedBuilder fr = new EmbedBuilder();
                fr.setColor(Color.red);

                fr.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

                fr.setDescription("Jobs\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                        "'$manageRitual' to manage rituals  \n");
                event.getChannel().sendMessage(fr.build()).queue();


                //event.getChannel().sendMessage("You're ")
            } else if (event.getMessage().getMember().getRoles().contains(ruler)) {
                event.getChannel().sendMessage("You cannot be a priest. It is beneath you").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Farmer)) {
                event.getChannel().sendMessage("You cannot be a priest.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(warrior)) {
                event.getChannel().sendMessage("You cannot be a priest.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Peasant)) {
                event.getChannel().sendMessage("You cannot be a priest.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Builder)) {
                event.getChannel().sendMessage("You cannot be a priest.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Occultist)) {
                event.getChannel().sendMessage("You cannot be a priest.").queue();

            }


        }

        List<Double> pIncome = new ArrayList<>();
        pIncome.add(5023.51);
        pIncome.add(8094.23);
        pIncome.add(10394.55);
        int indexP = (int) (Math.random() * pIncome.size());
        List<String> pQuestions = new ArrayList<>();
        String dragons = "What fire-breathing flying lizards are associated with Tarkon?";
        pQuestions.add(dragons);
        String Milk = "What nickname does the one who loves Milk go by?";
        pQuestions.add(Milk);
        String Jupes = "What is the name of Auralizings cat?";
        pQuestions.add(Jupes);

        int thePQ = (int) (Math.random() * Questions.size());
        double pAmount = pIncome.get(indexP);
        BigDecimal pecAmount = BigDecimal.valueOf(pAmount);

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$manageRitual")) {


            event.getChannel().sendMessage("You have chosen to lead the rituals. You may earn: $ " + pAmount).queue();
            event.getChannel().sendMessage(pQuestions.get(thePQ)).queue();
        }
        if (event.getMessage().getContentRaw().equalsIgnoreCase("Tarkon")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (pQuestions.get(thePQ).equals(dragons) && event.getMessage().getContentRaw().equalsIgnoreCase("dragons")) {
                //event.getChannel().sendMessage("What will your answer be?").queue();
                event.getChannel().sendMessage("Correct! You have earned: $ " + pecAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(pecAmount));
                        rs.updateInt(3, rs.getInt(3) + 250);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +250! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, pecAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Milk")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (pQuestions.get(thePQ).equals(Milk) && event.getMessage().getContentRaw().equalsIgnoreCase("Milk")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + pecAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(pecAmount));
                        rs.updateInt(3, rs.getInt(3) + 350);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +350! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, pecAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Jupiter")) {

            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (pQuestions.get(thePQ).equals(Jupes) && event.getMessage().getContentRaw().equalsIgnoreCase("Jupiter")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + pecAmount).queue();
                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(pecAmount));
                        rs.updateInt(3, rs.getInt(3) + 355);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +355! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, pecAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }

           /*
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {


            }




            if (Questions.get(theQuestion).equals(Bicep)) {
                event.getChannel().sendMessage("What will your answer be?").queue();
            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {


            }


            if (Questions.get(theQuestion).equals(Banga)) {
                event.getChannel().sendMessage("What will your answer be?").queue();

            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {


            }

            */

        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$warrior")) {
            event.getMessage().delete().queue();
            Role Peasant = event.getGuild().getRoleById("836768425900376154");
            Role Occultist = event.getGuild().getRoleById("836768743475380274");
            Role Builder = event.getGuild().getRoleById("836767806364188672");
            Role Farmer = event.getGuild().getRoleById("836767723324440626");
            Role warrior = event.getGuild().getRoleById("836768190251270155");
            Role priest = event.getGuild().getRoleById("836767849699344405");
            Role ruler = event.getGuild().getRoleById("836767926374629467");
            Role theSultan = event.getGuild().getRoleById("813213690379370506");
            Role theGrand = event.getGuild().getRoleById("834509928689041429");
            ArrayList<Role> sultanRoles = new ArrayList<>();
            sultanRoles.add(theSultan);
            sultanRoles.add(theGrand);
            Member ex = event.getMessage().getMember();
            ArrayList<Role> theRoles = new ArrayList<>();
            theRoles.add(Peasant);
            theRoles.add(warrior);
            theRoles.add(Farmer);
            theRoles.add(Occultist);
            theRoles.add(Builder);
            theRoles.add(ruler);
            theRoles.add(priest);


            if (!Objects.requireNonNull(event.getMessage().getMember()).getRoles().contains(theRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(1)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(2)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(3)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(4)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(5)) && !event.getMessage().getMember().getRoles().contains(theRoles.get(6))) {

                if (!event.getMessage().getMember().getRoles().contains(sultanRoles.get(0)) && !event.getMessage().getMember().getRoles().contains(sultanRoles.get(1))) {
                    event.getMessage().getGuild().addRoleToMember(event.getMessage().getMember(), warrior).queue();
                    event.getChannel().sendMessage("You are now a warrior!").queue();
                } else {
                    event.getChannel().sendMessage("You cannot be a warrior. It is below you O Sultan!").queue();
                }

            }


            if (event.getMessage().getMember().getRoles().contains(warrior)) {


                EmbedBuilder fr = new EmbedBuilder();
                fr.setColor(Color.red);

                fr.setThumbnail("https://static.thenounproject.com/png/1381565-200.png");

                fr.setDescription("Jobs\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                        "'$war' to do mercernary work for Kemet. \n");
                event.getChannel().sendMessage(fr.build()).queue();


                //event.getChannel().sendMessage("You're ")
            } else if (event.getMessage().getMember().getRoles().contains(ruler)) {
                event.getChannel().sendMessage("You cannot be a warrior. It is beneath you").queue();

            } else if (event.getMessage().getMember().getRoles().contains(priest)) {
                event.getChannel().sendMessage("You cannot be a warrior.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Farmer)) {
                event.getChannel().sendMessage("You cannot be a warrior.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Peasant)) {
                event.getChannel().sendMessage("You cannot be a warrior.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Builder)) {
                event.getChannel().sendMessage("You cannot be a warrior.").queue();

            } else if (event.getMessage().getMember().getRoles().contains(Occultist)) {
                event.getChannel().sendMessage("You cannot be a warrior.").queue();

            }


        }

        List<Double> wIncome = new ArrayList<>();
        wIncome.add(223.51);
        wIncome.add(394.23);
        wIncome.add(494.55);
        Random Wrand = new Random();
        int Windex = (int) (Math.random() * wIncome.size());
        List<String> WQuestions = new ArrayList<>();
        String WOwl = "Who is the founder of Kemet?";
        WQuestions.add(WOwl);
        String WBicep = "Who won the last joust between Tinman and Bicep?";
        WQuestions.add(WBicep);
        String WBanga = "Whose weed looks like dog turds? Ryan or Banga?";
        WQuestions.add(WBanga);
        Random Wranded = new Random();
        int WtheQuestion = (int) (Math.random() * WQuestions.size());
        double WtheAmount = wIncome.get(Windex);
        BigDecimal WdecAmount = BigDecimal.valueOf(WtheAmount);

        Role warrior = event.getGuild().getRoleById("836768190251270155");

        if (event.getMessage().getContentRaw().equalsIgnoreCase("$war")) {
            if (event.getMessage().getMember().getRoles().contains(warrior)) {


                event.getChannel().sendMessage("You have chosen to do mercenary work. You may earn: $ " + WtheAmount).queue();
                event.getChannel().sendMessage(WQuestions.get(WtheQuestion)).queue();

            } else {
                event.getChannel().sendMessage("You are not a warrior. You cannot profit as one.").queue();
            }
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (WQuestions.get(WtheQuestion).equals(WOwl) && event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {
                //event.getChannel().sendMessage("What will your answer be?").queue();
                event.getChannel().sendMessage("Correct! You have earned: $ " + WtheAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(WdecAmount));
                        rs.updateInt(3, rs.getInt(3) + 150);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +150! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, WdecAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {
            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (WQuestions.get(WtheQuestion).equals(WBicep) && event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + WtheAmount).queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(WdecAmount));
                        rs.updateInt(3, rs.getInt(3) + 150);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +150! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, WdecAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {

            String id = event.getMessage().getMember().getId();
            String name = event.getMessage().getMember().getUser().getName();
            if (WQuestions.get(WtheQuestion).equals(WBanga) && event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {
                event.getChannel().sendMessage("Correct! You have earned: $ " + WtheAmount).queue();
                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;

                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        rs.updateBigDecimal(4, rs.getBigDecimal(4).add(WdecAmount));
                        rs.updateInt(3, rs.getInt(3) + 150);
                        rs.updateRow();
                        event.getChannel().sendMessage(name + ", your balance is now: $ " + rs.getBigDecimal(4)).queue();
                        event.getChannel().sendMessage(name + ", your karma has increased +150! ").queue();


                    } else {
                        PreparedStatement ps = connection.prepareStatement("INSERT INTO players values(?,?,?,?)");
                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, 100);
                        ps.setBigDecimal(4, WdecAmount);
                        ps.executeUpdate();
                        System.out.println("Inserted successfully");
                    }

                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        }

           /*
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Owl")) {


            }




            if (Questions.get(theQuestion).equals(Bicep)) {
                event.getChannel().sendMessage("What will your answer be?").queue();
            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Bicep")) {


            }


            if (Questions.get(theQuestion).equals(Banga)) {
                event.getChannel().sendMessage("What will your answer be?").queue();

            }
            if (event.getMessage().getContentRaw().equalsIgnoreCase("Banga")) {


            }

            */


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$rich")) {
            Role richer = event.getGuild().getRoleById("813213690379370506");
            Role richest = event.getGuild().getRoleById("834509928689041429");
            if (event.getMessage().getMember().getRoles().contains(richer)) {
                String id = event.getMessage().getMember().getId();
                String profName = event.getMessage().getMember().getUser().getName();

                event.getChannel().sendMessage("Sultan of Kemet! Your wealth has been replenished!").queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        rs.updateBigDecimal(4, BigDecimal.valueOf(99999454.43));
                        rs.updateRow();

                    }
                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            } else if (event.getMessage().getMember().getRoles().contains(richest)) {

                String id = event.getMessage().getMember().getId();
                String profName = event.getMessage().getMember().getUser().getName();
                event.getChannel().sendMessage("Grand Sultan of Kemet! Your wealth has been replenished!").queue();


                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        rs.updateBigDecimal(4, BigDecimal.valueOf(1099999454.43));
                        rs.updateRow();

                    }
                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            } else {
                event.getChannel().sendMessage("You are not among the Sultan rulers. You must work to earn your wealth!").queue();
            }


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$owlrich")) {
            //Role richer = event.getGuild().getRoleById("813213690379370506");
            Role owled = event.getGuild().getRoleById("842261599816253440");
            //Role richest = event.getGuild().getRoleById("834509928689041429");
            if (event.getMessage().getMember().getRoles().contains(owled)) {
                String id = event.getMessage().getMember().getId();
                String profName = event.getMessage().getMember().getUser().getName();

                event.getChannel().sendMessage("High King of Kemet! Your wealth has been replenished!").queue();

                String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
                try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);) {
                    //jdbc:sqlserver://localhost:1433;database=ice9
                    //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    String sql = "SELECT * FROM players WHERE id=" + id;
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        rs.updateBigDecimal(4, BigDecimal.valueOf(699999999999.99));
                        rs.updateRow();

                    }
                    rs.close();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            } else {


                event.getChannel().sendMessage("Power denied").queue();
            }


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$money")) {

            String id = event.getMessage().getMember().getId();
            String profName = event.getMessage().getMember().getUser().getName();
            EmbedBuilder mb = new EmbedBuilder();
            mb.setColor(Color.green);
            mb.setTitle("\uD835\uDDEC\uD835\uDDFC\uD835\uDE02\uD835\uDDFF \uD835\uDDFA\uD835\uDDFC\uD835\uDDFB\uD835\uDDF2\uD835\uDE06");

            //mb.setThumbnail("https://static.thenounproject.com/png/3572981-200.png");


            String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players WHERE id=" + id;
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {

                    mb.setDescription("\uD83D\uDCB0 $" + " " + rs.getBigDecimal(4));
                    //event.getChannel().sendMessage("Your money: $ " + rs.getBigDecimal(4)).queue();
                    event.getChannel().sendMessage(mb.build()).queue();
                }
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$karma")) {

            String id = event.getMessage().getMember().getId();
            String profName = event.getMessage().getMember().getUser().getName();
            EmbedBuilder kkb = new EmbedBuilder();
            kkb.setTitle("\uD835\uDDEC\uD835\uDDFC\uD835\uDE02\uD835\uDDFF \uD835\uDDDE\uD835\uDDEE\uD835\uDDFF\uD835\uDDFA\uD835\uDDEE\n");
            kkb.setColor(Color.blue);


            String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players WHERE id=" + id;
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    kkb.setDescription("\u2638:" + " " + rs.getInt(3));
                    //event.getChannel().sendMessage("Your karma:" + rs.getInt(3)).queue();
                    event.getChannel().sendMessage(kkb.build()).queue();
                }
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$topKarma")) {

            String id = event.getMessage().getMember().getId();
            String profName = event.getMessage().getMember().getUser().getName();
            EmbedBuilder kb = new EmbedBuilder();
            kb.setColor(Color.red);

            kb.setThumbnail("https://static.thenounproject.com/png/2987035-200.png");

            ArrayList<String> theNames = new ArrayList<>();
            ArrayList<Integer> theNums = new ArrayList<>();


            String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players ORDER BY karmaPoints DESC";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String name = rs.getString(2);
                    theNames.add(name);
                    int kaama = rs.getInt(3);
                    theNums.add(kaama);


                }
                    /*
                    HashMap<String,BigDecimal> fubz = new HashMap<>();


                    for(int i=0; i<theNames.size(); i++)
                    {
                    fubz.put(theNames.get(i), theDecs.get(i));

*/
                kb.setDescription("\u043a\u0454\u043c\u0454\u0442 \u043a\u03b1\u044f\u043c\u03b1 \u0442\u03c3\u03c1 \u0442\u0454\u03b7" + "\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                        theNames.get(0) + ":               \uD80C\uDC93\uD80C\uDD7D" + theNums.get(0) +
                        "\n" + theNames.get(1) + ":        \uD80C\uDC93\uD80C\uDD7D     " + theNums.get(1) +
                        "\n" + theNames.get(2) + ":        \uD80C\uDC93\uD80C\uDD7D      " + theNums.get(2) +
                        "\n" + theNames.get(3) + ":        \uD80C\uDC93\uD80C\uDD7D     " + theNums.get(3) +
                        "\n" + theNames.get(4) + ":        \uD80C\uDC93\uD80C\uDD7D    " + theNums.get(4) +
                        "\n" + theNames.get(5) + ":        \uD80C\uDC93\uD80C\uDD7D   " + theNums.get(5) +
                        "\n" + theNames.get(6) + ":        \uD80C\uDC93\uD80C\uDD7D  " + theNums.get(6) +
                        "\n" + theNames.get(7) + ":        \uD80C\uDC93\uD80C\uDD7D  " + theNums.get(7) +
                        "\n" + theNames.get(8) + ":        \uD80C\uDC93\uD80C\uDD7D   " + theNums.get(8) +
                        "\n" + theNames.get(9) + ":        \uD80C\uDC93\uD80C\uDD7D   " + theNums.get(9) +
                        "\n" + theNames.get(10) + ":       \uD80C\uDC93\uD80C\uDD7D  " + theNums.get(10)


                );
                event.getChannel().sendMessage(kb.build()).queue();
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        if (event.getMessage().getContentRaw().equalsIgnoreCase("$forbes")) {

            String id = event.getMessage().getMember().getId();
            String profName = event.getMessage().getMember().getUser().getName();
            EmbedBuilder fb = new EmbedBuilder();
            fb.setColor(Color.red);

            fb.setThumbnail("https://static.thenounproject.com/png/1063290-200.png");

            ArrayList<String> theNames = new ArrayList<>();
            ArrayList<BigDecimal> theDecs = new ArrayList<>();


            String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM players ORDER BY money DESC";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String name = rs.getString(2);
                    theNames.add(name);
                    BigDecimal moola = rs.getBigDecimal(4);
                    theDecs.add(moola);


                }
                    /*
                    HashMap<String,BigDecimal> fubz = new HashMap<>();


                    for(int i=0; i<theNames.size(); i++)
                    {
                    fubz.put(theNames.get(i), theDecs.get(i));

*/
                fb.setDescription("\u043a\u0454\u043c\u0454\u0442 \u0192\u03c3\u044f\u0432\u0454\u0455 \u0442\u03c3\u03c1 \u0442\u0454\u03b7\n" + "\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\uD80C\uDD32\n" +
                        theNames.get(0) + ": $ " + theDecs.get(0) +
                        "\n" + theNames.get(1) + ": $          " + theDecs.get(1) +
                        "\n" + theNames.get(2) + ": $          " + theDecs.get(2) +
                        "\n" + theNames.get(3) + ": $          " + theDecs.get(3) +
                        "\n" + theNames.get(4) + ": $          " + theDecs.get(4) +
                        "\n" + theNames.get(5) + ": $          " + theDecs.get(5) +
                        "\n" + theNames.get(6) + ": $          " + theDecs.get(6) +
                        "\n" + theNames.get(7) + ": $          " + theDecs.get(7) +
                        "\n" + theNames.get(8) + ": $          " + theDecs.get(8) +
                        "\n" + theNames.get(9) + ": $          " + theDecs.get(9) +
                        "\n" + theNames.get(10) + ": $         " + theDecs.get(10)


                );
                event.getChannel().sendMessage(fb.build()).queue();
                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }


        //


        //


        //event.getChannel().sendMessage("The member count without bots is: " + memberCount).queue();
        if (event.getMessage().getContentRaw().equalsIgnoreCase("$stats")) {
            event.getMessage().delete().queue();

            String id = event.getMessage().getMember().getId();
            String profName = event.getMessage().getMember().getUser().getName();
            int profPoints = 0;
            int profMoney = 0;
            int hp = 0;
            int kills = 0;
            int deaths = 0;
            int xp = 0;
            int level = 1;
            int attack = 0;
            int magic = 0;
            int defense = 0;
            int mana = 0;

            Role Peasant = event.getGuild().getRoleById("836768425900376154");
            Role Occultist = event.getGuild().getRoleById("836768743475380274");
            Role Builder = event.getGuild().getRoleById("836767806364188672");
            Role Farmer = event.getGuild().getRoleById("836767723324440626");
            Role priest = event.getGuild().getRoleById("836767849699344405");
            Role ruler = event.getGuild().getRoleById("836767926374629467");
            Role theSultan = event.getGuild().getRoleById("813213690379370506");
            Role theGrand = event.getGuild().getRoleById("834509928689041429");
            ArrayList<Role> sultanRoles = new ArrayList<>();
            sultanRoles.add(theSultan);
            sultanRoles.add(theGrand);
            Member ex = event.getMessage().getMember();
            ArrayList<Role> theRoles = new ArrayList<>();
            theRoles.add(Peasant);
            theRoles.add(warrior);
            theRoles.add(Farmer);
            theRoles.add(Occultist);
            theRoles.add(Builder);
            theRoles.add(ruler);
            theRoles.add(priest);


            EmbedBuilder si = new EmbedBuilder();
            si.setColor(Color.lightGray);
            si.setTitle("Stats");


            String jdbcURL = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(jdbcURL); Statement stmt = connection.createStatement();) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM inventory WHERE id=" + id;
                ResultSet rs = stmt.executeQuery(sql);
                if (!rs.next()) {
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO inventory values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    if (event.getMessage().getMember().getRoles().contains(warrior)) {
                        hp = 2000;
                        xp = 5;
                        deaths = 0;
                        kills = 0;
                        level = 1;
                        attack = 500;
                        defense = 300;
                        mana = 5;
                        magic = 1;
                    } else if (event.getMessage().getMember().getRoles().contains(sultanRoles.get(0))) {
                        hp = 5000;
                        xp = 50;
                        deaths = 0;
                        kills = 0;
                        level = 1;
                        attack = 300;
                        magic = 100;
                        defense = 1000;
                        mana = 1000;
                    } else if (event.getMessage().getMember().getRoles().contains(sultanRoles.get(1))) {
                        hp = 8000;
                        xp = 50;
                        level = 1;
                        deaths = 0;
                        kills = 0;
                        attack = 300;
                        magic = 100;
                        defense = 1500;
                        mana = 1000;
                    } else {
                        hp = 1000;
                        xp = 1;
                        level = 1;
                        attack = 50;
                        deaths = 0;
                        kills = 0;
                        magic = 1;
                        defense = 10;
                        mana = 5;
                    }
                    ps.setString(1, id);
                    ps.setInt(2, hp);
                    ps.setInt(3, xp);
                    ps.setString(4, profName);
                    ps.setString(5, "Null");
                    ps.setString(6, "Null");
                    ps.setInt(7, attack);
                    ps.setInt(8, defense);
                    ps.setInt(9, 100);
                    ps.setInt(10, magic);
                    ps.setInt(11, mana);
                    ps.setInt(12, level);
                    ps.setInt(13, 0);
                    ps.setInt(14, 0);


                    ps.executeUpdate();
                    System.out.println("Inserted successfully");
                } else {
                    //event.getChannel().sendMessage("Your id:" + rs.getString(1)).queue();
                    si.setTitle(rs.getString(4));
                    //event.getChannel().sendMessage("Your name: " + rs.getString(2)).queue();

                    si.setDescription("Level:" + " " + rs.getInt(12) + "\n" +
                            "HP : " + rs.getInt(2) + "\n" +
                            "Mana : " + rs.getInt(11) + "\n" +
                            "\u2694\uFE0F : " + rs.getInt(7) + "\n" +
                            "\uD83D\uDEE1\uFE0F : " + rs.getInt(8) + "\n" +
                            "\uD83E\uDE84 : " + rs.getInt(10) + "\n" +
                            "Kills : " + rs.getInt(13) + "\n" + "Deaths : " + rs.getInt(14) + "\n" +
                            "XP : " + rs.getInt(3)
                    );
                    //event.getChannel().sendMessage("Your Karma: " + rs.getInt(3)).queue();
                    //event.getChannel().sendMessage("Your money: $ " + rs.getBigDecimal(4)).queue();
                    event.getChannel().sendMessage(si.build()).queue();
                }
                rs.close();


            } catch (SQLException exa) {
                exa.printStackTrace();
            }


        }


        String[] sultanTechniques = {"Biceps Fury", "Milks workout", "Sultans decree", "ICE-9"};
        String[] attackTech = {"Punch", "Kick"};
        String[] sultanMagic = {"\uD80C\uDE88\uD80C\uDC61\uD80C\uDD98\uD80C\uDC80\uD80C\uDF16\uD80C\uDC5E : Kemet State", "Owls Tribulation"};
        String[] magicAttack = {"'Gore' by Nick", "Chaos of Nebuchadnezzar", "Planetary Devestation:Jupiter", "Tarkon Prices Out"};

        EmbedBuilder attackMenu = new EmbedBuilder();
        attackMenu.setTitle("Combat Techniques");
        attackMenu.setColor(Color.red);
        attackMenu.setDescription("Type the number to make your choice:" + "\n" + "1." + attackTech[0] + "\n" + "2." + attackTech[1]);

        EmbedBuilder sultanAMenu = new EmbedBuilder();
        sultanAMenu.setTitle("Combat Techniques");
        sultanAMenu.setColor(Color.red);
        sultanAMenu.setDescription("Type the number to make your choice:" + "\n" + "1." + sultanTechniques[0] + "\n" + "2." + sultanTechniques[1] + "\n" +
                "3." + sultanTechniques[2] + "\n" + "4." + sultanTechniques[3]);

        EmbedBuilder magicOfSultan = new EmbedBuilder();
        magicOfSultan.setTitle("Combat Techniques");
        magicOfSultan.setColor(Color.red);
        magicOfSultan.setDescription("Type the number to make your choice:" + "\n" + "1." + sultanMagic[0] + ": *This technique transforms you into a being of absolute destruction*" + "\n"
                + "2." + sultanMagic[1] + ": *Owls Tribulation calls upon Owl himself to subdue your enemies*");


        EmbedBuilder magicMenu = new EmbedBuilder();
        magicMenu.setTitle("Magic Techniques");
        magicMenu.setColor(Color.red);
        magicMenu.setDescription("Type the number to make your choice:" + "\n" + "1." + magicAttack[0] + "\n" + "2." + magicAttack[1] + "\n" + "3." + magicAttack[2] + "4." + magicAttack[3]);
        Role thePSultan = event.getGuild().getRoleById("813213690379370506");
        Role theGSultan = event.getGuild().getRoleById("834509928689041429");


        String[] fight = event.getMessage().getContentRaw().split(" ");
        if (give.length == 1 && give[0].equalsIgnoreCase("$fight")) {

            event.getChannel().sendMessage("To fight, type $fight [name]").queue();
        } else if (fight.length >= 2 && give[0].equalsIgnoreCase("$fight")) {
            List<Member> fightin = event.getMessage().getMentionedMembers();

            Member toFight = fightin.get(0);

            event.getChannel().sendMessage("You have chosen to battle: " + toFight.getNickname()).queue();
            event.getChannel().sendMessage("Type 'A' to attack, type 'M' to invoke the magic menu").queue();


            String id = Objects.requireNonNull(event.getMessage().getMember()).getId();
            String mentionID = fightin.get(0).getId();
            String profName = event.getMessage().getMember().getUser().getName();
            String mentionName = fightin.get(0).getUser().getName();

            String url = "jdbc:sqlserver://localhost:1433;database=ice9; integratedSecurity=true;";
            try (Connection connection = DriverManager.getConnection(url); Statement stmt3 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE); Statement stmt4 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                //jdbc:sqlserver://localhost:1433;database=ice9
                //Statement a = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM inventory WHERE id=" + id;
                String sql2 = "SELECT * FROM inventory WHERE id=" + mentionID;
                ResultSet rs = stmt3.executeQuery(sql);
                ResultSet r2 = stmt4.executeQuery(sql2);
                //connection.setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT);

                try {
                    if (rs.next()) {


                        getEventwaiter().waitForEvent(MessageReceivedEvent.class, e -> e.getMessage().getContentRaw().equalsIgnoreCase("A"), e -> {


                                            e.getChannel().sendMessage("asdfa").queue();

                                    if (e.getMessage().getMember().getRoles().contains(thePSultan)) {
                                        e.getChannel().sendMessage(sultanAMenu.build()).queue();
                                        getEventwaiter().waitForEvent(MessageReceivedEvent.class, f -> f.getMessage().getContentRaw().equalsIgnoreCase("1"), f -> {
                                                    try {

                                                            f.getChannel().sendMessage("You have chose to invoke Bicep's fury.").queue();
                                                            f.getChannel().sendMessage("Your attack points are:" + rs.getInt(7)).queue();
                                                           /*
                                                            int bicepAttack = 100 + (int) (Math.random() * rs.getInt(7));
                                                            f.getChannel().sendMessage("You have dealt " + bicepAttack + "damage.").queue();
                                                                if (bicepAttack > r2.getInt(8)) {

                                                                    r2.updateInt(2, bicepAttack - r2.getInt(2));
                                                                    r2.updateRow();

                                                                    if (r2.getInt(2) == 0) {
                                                                        int xPUp = 10 + (int) (Math.random() * 500);
                                                                        int xpLose = 10 + (int) (Math.random() * 300);
                                                                        rs.updateInt(13, rs.getInt(13) + 1);
                                                                        rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                        rs.updateInt(2, 5000);

                                                                        f.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();

                                                                        r2.updateInt(14, r2.getInt(14) + 1);
                                                                        r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                        r2.updateInt(2, 2000);
                                                                        r2.updateInt(8, 1000);
                                                                        f.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();

                                                                        rs.updateRow();
                                                                        r2.updateRow();

                                                                        f.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                        //break;
                                                                    }

                                                                } else {
                                                                    r2.updateInt(8, r2.getInt(8) - bicepAttack);
                                                                    r2.updateRow();
                                                                }

                                                            */



                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }
                                        );
                                        getEventwaiter().waitForEvent(MessageReceivedEvent.class, g -> g.getMessage().getContentRaw().equalsIgnoreCase("2"), g -> {
                                                    try {
                                                        if (g.getMessage().getContentRaw().equalsIgnoreCase("2")) {
                                                            g.getChannel().sendMessage("You have chose to invoke Milks workout.").queue();
                                                            int milksWorkout = 10 + (int) (Math.random() * rs.getInt(7));
                                                            g.getChannel().sendMessage("You have dealt " + milksWorkout + "damage.").queue();
                                                            if (milksWorkout > r2.getInt(8)) {


                                                                r2.updateInt(2, milksWorkout - r2.getInt(2));
                                                                r2.updateRow();
                                                                if (r2.getInt(2) == 0) {
                                                                    int xPUp = 10 + (int) (Math.random() * 500);
                                                                    int xpLose = 10 + (int) (Math.random() * 300);
                                                                    rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                    rs.updateInt(13, rs.getInt(13) + 1);
                                                                    rs.updateInt(2, 5000);
                                                                    g.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();
                                                                    r2.updateInt(14, r2.getInt(14) + 1);
                                                                    r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                    r2.updateInt(2, 2000);
                                                                    r2.updateInt(8, 1000);

                                                                    g.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();
                                                                    rs.updateRow();
                                                                    r2.updateRow();

                                                                    g.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                    //break;
                                                                }
                                                            } else {
                                                                r2.updateInt(8, r2.getInt(8) - milksWorkout);
                                                                r2.updateRow();
                                                            }
                                                        }
                                                    } catch (SQLException ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }
                                        );
                                        getEventwaiter().waitForEvent(MessageReceivedEvent.class, h -> h.getMessage().getContentRaw().equalsIgnoreCase("3"), h -> {
                                                    try {
                                                        if (h.getMessage().getContentRaw().equalsIgnoreCase("3")) {
                                                            h.getChannel().sendMessage("You have chose to invoke Sultans Decree.").queue();
                                                            int decree = 35 + (int) (Math.random() * rs.getInt(7));
                                                            h.getChannel().sendMessage("You have dealt " + decree + "damage.").queue();
                                                            if (decree > r2.getInt(8)) {

                                                                r2.updateInt(2, decree - r2.getInt(2));
                                                                r2.updateRow();
                                                                if (r2.getInt(2) == 0) {
                                                                    int xPUp = 10 + (int) (Math.random() * 500);
                                                                    int xpLose = 10 + (int) (Math.random() * 300);
                                                                    rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                    rs.updateInt(13, rs.getInt(13) + 1);
                                                                    rs.updateInt(2, 5000);
                                                                    h.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();
                                                                    r2.updateInt(14, r2.getInt(14) + 1);
                                                                    r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                    r2.updateInt(2, 2000);
                                                                    r2.updateInt(8, 1000);
                                                                    h.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();

                                                                    rs.updateRow();
                                                                    r2.updateRow();

                                                                    h.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                    // break;
                                                                }
                                                            } else {
                                                                r2.updateInt(8, r2.getInt(8) - decree);
                                                                r2.updateRow();
                                                            }
                                                        }
                                                    } catch (SQLException ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }
                                        );

                                        getEventwaiter().waitForEvent(MessageReceivedEvent.class, k -> k.getMessage().getContentRaw().equalsIgnoreCase("4"), k -> {

                                                    try {
                                                        if (k.getMessage().getContentRaw().equalsIgnoreCase("4")) {
                                                            k.getChannel().sendMessage("You have chose to invoke ICE-9").queue();
                                                            int[] ice = {100, 1000};
                                                            Random r = new Random();
                                                            int ranIce = r.nextInt(ice.length);
                                                            int chosenIce = ice[ranIce];

                                                            k.getChannel().sendMessage("You have dealt " + chosenIce + "damage.").queue();
                                                            if (chosenIce > r2.getInt(8)) {


                                                                r2.updateInt(2, chosenIce - r2.getInt(2));
                                                                rs.updateInt(2, 50);
                                                                k.getChannel().sendMessage("Your HP has been cut to 50 due to invoking ICE-9").queue();
                                                                r2.updateRow();
                                                                rs.updateRow();
                                                                if (r2.getInt(2) == 0) {
                                                                    int xPUp = 10 + (int) (Math.random() * 500);
                                                                    int xpLose = 10 + (int) (Math.random() * 300);
                                                                    rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                    rs.updateInt(13, rs.getInt(13) + 1);
                                                                    rs.updateInt(2, 5000);
                                                                    k.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();
                                                                    r2.updateInt(14, r2.getInt(14) + 1);

                                                                    r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                    r2.updateInt(2, 2000);
                                                                    r2.updateInt(8, 1000);
                                                                    k.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();


                                                                    rs.updateRow();
                                                                    r2.updateRow();

                                                                    k.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                    //break;
                                                                }
                                                            } else {
                                                                r2.updateInt(8, r2.getInt(8) - chosenIce);
                                                                r2.updateRow();
                                                            }
                                                        }


                                                    } catch (SQLException ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }
                                        );
                                        if (e.getMessage().getMember().getRoles().contains(theGSultan)) {
                                            e.getChannel().sendMessage(sultanAMenu.build()).queue();
                                            getEventwaiter().waitForEvent(MessageReceivedEvent.class, gr -> gr.getMessage().getContentRaw().equalsIgnoreCase("1"), gr -> {
                                                        try {
                                                            if (event.getMessage().getContentRaw().equalsIgnoreCase("1")) {

                                                                event.getChannel().sendMessage("You have chose to invoke Bicep's fury.").queue();
                                                                int bicepAttack = 120 + (int) (Math.random() * rs.getInt(7));
                                                                event.getChannel().sendMessage("You have dealt " + bicepAttack + "damage.").queue();
                                                                if (bicepAttack > r2.getInt(8)) {
                                                                    r2.updateInt(2, bicepAttack - r2.getInt(2));
                                                                    r2.updateRow();
                                                                    if (r2.getInt(2) == 0) {
                                                                        int xPUp = 10 + (int) (Math.random() * 500);
                                                                        int xpLose = 10 + (int) (Math.random() * 300);
                                                                        rs.updateInt(13, rs.getInt(13) + 1);
                                                                        rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                        rs.updateInt(2, 5000);
                                                                        event.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();

                                                                        r2.updateInt(14, r2.getInt(14) + 1);
                                                                        r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                        r2.updateInt(2, 2000);
                                                                        r2.updateInt(8, 1000);
                                                                        event.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();

                                                                        rs.updateRow();
                                                                        r2.updateRow();

                                                                        event.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                        //break;
                                                                    }

                                                                } else {
                                                                    r2.updateInt(8, r2.getInt(8) - bicepAttack);
                                                                    r2.updateRow();
                                                                }
                                                            }
                                                        } catch (SQLException ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    }
                                            );

                                            getEventwaiter().waitForEvent(MessageReceivedEvent.class, grr -> grr.getMessage().getContentRaw().equalsIgnoreCase("2"), grr -> {
                                                        try {
                                                            if (grr.getMessage().getContentRaw().equalsIgnoreCase("2")) {
                                                                grr.getChannel().sendMessage("You have chose to invoke Milks workout.").queue();
                                                                int milksWorkout = 20 + (int) (Math.random() * rs.getInt(7));
                                                                grr.getChannel().sendMessage("You have dealt " + milksWorkout + "damage.").queue();
                                                                if (milksWorkout > r2.getInt(8)) {
                                                                    r2.updateInt(2, milksWorkout - r2.getInt(2));
                                                                    r2.updateRow();
                                                                    if (r2.getInt(2) == 0) {
                                                                        int xPUp = 10 + (int) (Math.random() * 500);
                                                                        int xpLose = 10 + (int) (Math.random() * 300);
                                                                        rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                        rs.updateInt(13, rs.getInt(13) + 1);
                                                                        rs.updateInt(2, 5000);
                                                                        grr.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();
                                                                        r2.updateInt(14, r2.getInt(14) + 1);
                                                                        r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                        r2.updateInt(2, 2000);
                                                                        r2.updateInt(8, 1000);
                                                                        grr.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();
                                                                        rs.updateRow();
                                                                        r2.updateRow();

                                                                        grr.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                        //break;
                                                                    }
                                                                } else {
                                                                    r2.updateInt(8, r2.getInt(8) - milksWorkout);
                                                                    r2.updateRow();
                                                                }
                                                            }
                                                        } catch (SQLException ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    }
                                            );

                                            getEventwaiter().waitForEvent(MessageReceivedEvent.class, grs -> grs.getMessage().getContentRaw().equalsIgnoreCase("3"), grs -> {
                                                        try {
                                                            if (grs.getMessage().getContentRaw().equalsIgnoreCase("3")) {
                                                                grs.getChannel().sendMessage("You have chose to invoke Grand Sultans Decree.").queue();
                                                                int decree = 200 + (int) (Math.random() * rs.getInt(7));
                                                                grs.getChannel().sendMessage("You have dealt " + decree + "damage.").queue();
                                                                if (decree > r2.getInt(8)) {
                                                                    r2.updateInt(2, decree - r2.getInt(2));
                                                                    r2.updateRow();
                                                                    if (r2.getInt(2) == 0) {
                                                                        int xPUp = 10 + (int) (Math.random() * 500);
                                                                        int xpLose = 10 + (int) (Math.random() * 300);
                                                                        rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                        rs.updateInt(13, rs.getInt(13) + 1);
                                                                        rs.updateInt(2, 5000);
                                                                        grs.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();
                                                                        r2.updateInt(14, r2.getInt(14) + 1);
                                                                        r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                        r2.updateInt(2, 2000);
                                                                        r2.updateInt(8, 1000);
                                                                        grs.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();

                                                                        rs.updateRow();
                                                                        r2.updateRow();

                                                                        grs.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                        //break;
                                                                    }
                                                                } else {
                                                                    r2.updateInt(8, r2.getInt(8) - decree);
                                                                    r2.updateRow();
                                                                }
                                                            }
                                                        } catch (SQLException ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    }
                                            );
                                            getEventwaiter().waitForEvent(MessageReceivedEvent.class, grf -> grf.getMessage().getContentRaw().equalsIgnoreCase("4"), grf -> {
                                                        try {
                                                            if (grf.getMessage().getContentRaw().equalsIgnoreCase("4")) {
                                                                grf.getChannel().sendMessage("You have chose to invoke ICE-9").queue();
                                                                int[] ice = {0, 1000};
                                                                Random r = new Random();
                                                                int ranIce = r.nextInt(ice.length);
                                                                int chosenIce = ice[ranIce];

                                                                grf.getChannel().sendMessage("You have dealt " + chosenIce + "damage.").queue();
                                                                if (chosenIce > r2.getInt(8)) {
                                                                    r2.updateInt(2, chosenIce - r2.getInt(2));
                                                                    rs.updateInt(2, 50);
                                                                    grf.getChannel().sendMessage("Your HP has been cut to 50 due to invoking ICE-9").queue();
                                                                    r2.updateRow();
                                                                    rs.updateRow();
                                                                    if (r2.getInt(2) == 0) {
                                                                        int xPUp = 10 + (int) (Math.random() * 500);
                                                                        int xpLose = 10 + (int) (Math.random() * 300);
                                                                        rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                        rs.updateInt(13, rs.getInt(13) + 1);
                                                                        rs.updateInt(2, 5000);
                                                                        grf.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();
                                                                        r2.updateInt(14, r2.getInt(14) + 1);

                                                                        r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                        r2.updateInt(2, 2000);
                                                                        grf.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();


                                                                        rs.updateRow();
                                                                        r2.updateRow();

                                                                        grf.getChannel().sendMessage("O great Sultan, you have destroyed" + " " + mentionName).queue();
                                                                        //break;
                                                                    }
                                                                } else {
                                                                    r2.updateInt(8, r2.getInt(8) - chosenIce);
                                                                    r2.updateRow();
                                                                }
                                                            }
                                                        } catch (SQLException ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    }
                                            );


                                        } else {
                                            e.getChannel().sendMessage(attackMenu.build()).queue();
                                            //            String[] attackTech = {"Punch", "Kick"};
                                            getEventwaiter().waitForEvent(MessageReceivedEvent.class, ne -> ne.getMessage().getContentRaw().equalsIgnoreCase("A"), ne -> {
                                                        try {
                                                            if (ne.getMessage().getContentRaw().equalsIgnoreCase("1")) {

                                                                ne.getChannel().sendMessage("You have chosen to punch.").queue();
                                                                int sPunch = 45 + (int) (Math.random() * rs.getInt(7));
                                                                ne.getChannel().sendMessage("You have dealt " + sPunch + "damage.").queue();
                                                                if (sPunch > r2.getInt(8)) {
                                                                    r2.updateInt(2, sPunch - r2.getInt(2));
                                                                    r2.updateRow();
                                                                    if (r2.getInt(2) == 0) {
                                                                        int xPUp = 10 + (int) (Math.random() * rs.getInt(7));
                                                                        int xpLose = 10 + (int) (Math.random() * rs.getInt(7));
                                                                        rs.updateInt(13, rs.getInt(13) + 1);
                                                                        rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                        rs.updateInt(2, 5000);
                                                                        ne.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();

                                                                        r2.updateInt(14, r2.getInt(14) + 1);
                                                                        r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                        r2.updateInt(2, 2000);
                                                                        r2.updateInt(8, 1000);
                                                                        ne.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();

                                                                        rs.updateRow();
                                                                        r2.updateRow();

                                                                        ne.getChannel().sendMessage("Commoner, you have destroyed" + " " + mentionName).queue();
                                                                        //break;
                                                                    }

                                                                } else {
                                                                    r2.updateInt(8, r2.getInt(8) - sPunch);
                                                                    r2.updateRow();
                                                                }
                                                            }
                                                        } catch (Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    }
                                            );

                                            getEventwaiter().waitForEvent(MessageReceivedEvent.class, ve -> ve.getMessage().getContentRaw().equalsIgnoreCase("2"), ve -> {
                                                        try {
                                                            if (ve.getMessage().getContentRaw().equalsIgnoreCase("2")) {
                                                                ve.getChannel().sendMessage("You have chosen to kick.").queue();
                                                                int sKick = 45 + (int) (Math.random() * rs.getInt(7));
                                                                ve.getChannel().sendMessage("You have dealt " + sKick + "damage.").queue();
                                                                if (sKick > r2.getInt(8)) {
                                                                    r2.updateInt(2, sKick - r2.getInt(2));
                                                                    r2.updateRow();
                                                                    if (r2.getInt(2) == 0) {
                                                                        int xPUp = 10 + (int) (Math.random() * rs.getInt(7));
                                                                        int xpLose = 10 + (int) (Math.random() * rs.getInt(7));
                                                                        rs.updateInt(3, rs.getInt(3) + xPUp);
                                                                        rs.updateInt(13, rs.getInt(13) + 1);
                                                                        rs.updateInt(2, 5000);
                                                                        ve.getChannel().sendMessage("Your health has replenished!" + " " + profName).queue();
                                                                        r2.updateInt(14, r2.getInt(14) + 1);
                                                                        r2.updateInt(3, r2.getInt(3) + xpLose);
                                                                        r2.updateInt(2, 2000);
                                                                        r2.updateInt(8, 1000);
                                                                        ve.getChannel().sendMessage("Your health has replenished!" + " " + mentionName).queue();
                                                                        rs.updateRow();
                                                                        r2.updateRow();

                                                                        ve.getChannel().sendMessage("O commoner, you have destroyed" + " " + mentionName).queue();

                                                                        //break;
                                                                    }
                                                                } else {
                                                                    r2.updateInt(8, r2.getInt(8) - sKick);
                                                                    r2.updateRow();
                                                                }
                                                            }
                                                        } catch (SQLException ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    }
                                            );


                                        }


                                    }

                                }
                        );


                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                rs.close();


            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        }






        public void clear(TextChannel channel)
        {
            final boolean[] isWorking = {false};
            if (isWorking[0])
            {
                channel.sendMessage("I'm busy right now...").queue();
                return;
            }

            isWorking[0] = true;

            OffsetDateTime twoWeeksAgo = OffsetDateTime.now().minus(2, ChronoUnit.WEEKS);

            System.out.println("Deleting messages in channel: " + channel);

            new Thread(() ->
            {
                while (isWorking[0])
                {
                    List<Message> messages = channel.getHistory().retrievePast(50).complete();

                    messages.removeIf(m -> m.getTimeCreated().isBefore(twoWeeksAgo));

                    if (messages.isEmpty())
                    {
                        isWorking[0] = false;
                        System.out.println("Done deleting: " + channel);
                        return;
                    }

                    messages.forEach(m -> System.out.println("Deleting: " + m));
                    channel.deleteMessages(messages).complete();
                }
            })
                    .run();
        }

}
