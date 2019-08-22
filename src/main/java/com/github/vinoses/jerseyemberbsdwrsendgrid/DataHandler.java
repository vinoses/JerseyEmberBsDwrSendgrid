
package com.github.vinoses.jerseyemberbsdwrsendgrid;


import org.directwebremoting.datasync.Directory;
import org.directwebremoting.datasync.MapStoreProvider;
import org.directwebremoting.datasync.StoreProvider;

import java.util.*;
import java.util.regex.Pattern;

/**
 * {@link #getSmallData()},
 * {@link #setData(Data)}
 * {@link #deleteData(String)}
 * {@link StoreProvider}
 * {@link #getMatchingFromLargeData(String)}
 */
public class DataHandler
{
  /**
   * Pre-populate the small and large data
   */
  public DataHandler()
  {
    smallData = createData(10);
    MapStoreProvider<Data> provider = new MapStoreProvider<Data>(createData(1000), Data.class);
    Directory.register("largeData", provider);
    largeData = provider.asMap();
  }

  /**
   * We maintain 2 lists of data, small (~10 parts with properties) and large (~1000 parts).
   * The smaller is for when we want to show them all on the screen at the same time,
   * the larger for when we want a revolving collection on the screen.
   */
  public Collection<Data> getSmallData()
  {
    return smallData.values();
  }

  /**
   * Insert data into the DataHandler set
   * @param data The data to add or update
   */
  public String setData(Data data)
  {
    smallData.put(data.getId(), data);
    return "Updated values for " + data.getName();
  }

  /**
   * Delete data from the set in DataHandler
   * @param id The id of the data to delete
   */
  public String deleteData(String id)
  {
    Data data = smallData.remove(id);
    if (data == null)
    {
      return "Data does not exist";
    }
    else
    {
      return "Deleted " + data.getName();
    }
  }

  /**
   * Delete data from the set of largeData DataHandler
   * @param id The id of the data to delete
   */
  public String deleteDatas(String id)
  {
    Data data = largeData.remove(id);
    if (data == null)
    {
      return "Data does not exist";
    }
    else
    {
      return "Deleted " + data.getName();
    }
  }

  /**
   * Accessor for a subset of the current list of DataHandler
   * @return the current list of DataHandler
   */
  public List<Data> getMatchingFromLargeData(String filter)
  {
    List<Data> reply = new ArrayList<Data>();
    Pattern regex = Pattern.compile(filter, Pattern.CASE_INSENSITIVE);
    for (Data data : largeData.values())
    {
      if (regex.matcher(data.getName()).find())
      {
        reply.add(data);
      }
    }
    return reply;
  }

  /**
   * @see #getSmallData()
   */
  private final Map<String, Data> smallData;

  /**
   * @see #getMatchingFromLargeData(String)
   */
  private final Map<String, Data> largeData;

  /**
   * Both datas are created in the same way.
   */
  private static Map<String, Data> createData(int count)
  {
    Map<String, Data> reply = new HashMap<String, Data>();
    for (int i = 0; i < count; i++)
    {
      Data data = new Data(true);
      reply.put(data.getId(), data);
    }
    return reply;
  }
}
