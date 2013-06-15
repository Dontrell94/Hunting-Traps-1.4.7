package huntingTraps.common;

import huntingTraps.client.HuntingTrapsClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = HuntingTraps.ID, name = "Hunting Traps", version = "0.2.9")
@NetworkMod(clientSideRequired=true,serverSideRequired=false) 

public class HuntingTraps
{
        public static final String ID = "Hunting Traps";
        public static final String VERSION = "0.3.0";

        @Instance(ID)
        public static HuntingTraps instance;
        
        //Blocks
        public static Block GPP;
        public static Block CageTrap;
        public static Block FireCage;
        public static Block Pitfall;
        public static Block IFireTrap;
        public static Block FakeGrass;
        public static Block FakeSand;
        public static Block InvisPrsrPlate;
        public static Block Spikes;
        
        //Config
        public static int GPPID;
        public static int CageTID;
        public static int FireCageID;
        public static int PitfallID;
        public static int IFireTrapID;
        public static int FakeGrassID;
        public static int FakeSandID;
        public static int InvisPrsrPlateID;
        public static int SpikesID;
        
        //Creative Tab
        public static CreativeTabs customTab = new CreativeTabHuntingTraps("Hunting Traps");
        
        @SidedProxy(clientSide="huntingTraps.client.HuntingTrapsClientProxy", serverSide="huntingTraps.client.HuntingTrapsCommonProxy")
        public static HuntingTrapsClientProxy proxy = new HuntingTrapsClientProxy();
        
        @PreInit
        public void PreInit(FMLPreInitializationEvent event)
        {
                //Logger
                        //logger = Logger.getLogger(ID);
                        //logger.setParent(FMLLog.getLogger());
                                
                        //Configurations
                        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
                        config.load();
                        CageTID = config.getBlock("Cage Trap", 2001).getInt();
                        FireCageID = config.getBlock("Fire Cage Trap", 2002).getInt();
                        GPPID = config.getBlock("Grass Pressure Plate", 2003).getInt();
                        PitfallID = config.getBlock("Pitfall Trap", 2004).getInt();
                        IFireTrapID = config.getBlock("Incinerating Fire Trap", 2005).getInt();
                        FakeGrassID = config.getBlock("Fake Grass Covering", 2006).getInt();
                        FakeSandID = config.getBlock("Fake Sand Covering", 2007).getInt();
                        InvisPrsrPlateID = config.getBlock("Invisible Pressure Plate", 2008).getInt();
                        SpikesID = config.getBlock("Spikes", 2009).getInt();
            config.save();
        }        
        
                @Init
                public void Init(FMLInitializationEvent event)
                {
                        proxy.registerRenders();
                        
                        //Properties
                        GPP = new GPP(GPPID, EnumMobType.everything).setBlockName("GPP");
                        CageTrap = new CageTrap(CageTID, 4).setBlockName("CageTrap");
                        FireCage = new FireCage(FireCageID, 1).setBlockName("FireCage");
                        Pitfall = new Pitfall(PitfallID, 11).setBlockName("Pitfall");
                        IFireTrap = new IFireTrap(IFireTrapID, 7).setBlockName("IFireTrap");
                        FakeGrass = new FakeGrass(FakeGrassID, 0).setBlockName("FakeGrass");
                        FakeSand = new FakeSand(FakeSandID, 0).setBlockName("FakeSand");
                        InvisPrsrPlate = new InvisPrsrPlate(InvisPrsrPlateID, 0, EnumMobType.everything).setBlockName("InvisPrsrPlate");
                        Spikes = new Spikes(SpikesID, 14).setBlockName("Spikes");
                        
                        proxy.registerBlocks();
                        proxy.addNames();                       
                        proxy.addRecipes();
                        
                        //Creative Tab
                        LanguageRegistry.instance().addStringLocalization("Hunting Traps", "en_US", "Hunting Traps");
                        GPP.setCreativeTab(HuntingTraps.customTab);
                        CageTrap.setCreativeTab(HuntingTraps.customTab);
                        FireCage.setCreativeTab(HuntingTraps.customTab);
                        Pitfall.setCreativeTab(HuntingTraps.customTab);
                        IFireTrap.setCreativeTab(HuntingTraps.customTab);
                        FakeGrass.setCreativeTab(HuntingTraps.customTab);
                        FakeSand.setCreativeTab(HuntingTraps.customTab);
                        InvisPrsrPlate.setCreativeTab(HuntingTraps.customTab);
                        Spikes.setCreativeTab(HuntingTraps.customTab);
                }

        @PostInit
        public void afterLoaded(FMLPostInitializationEvent event){
                
        }
}